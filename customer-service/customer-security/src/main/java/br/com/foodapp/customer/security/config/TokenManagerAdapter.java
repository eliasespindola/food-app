package br.com.foodapp.customer.security.config;

import br.com.foodapp.customer.application.service.ports.output.security.TokenManager;
import br.com.foodapp.customer.domain.core.entity.Customer;
import br.com.foodapp.customer.security.mapper.CustomerSecurityMapper;
import br.com.foodapp.customer.security.model.CustomerDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.UUID;

@Component
public class TokenManagerAdapter implements TokenManager {

    @Value("${customer.api.jwt.secret}")
    private String secret;

    @Value("${customer.api.jwt.expirationTime}")
    private long expirationIsMillis;
    private final CustomerSecurityMapper customerSecurityMapper;

    public TokenManagerAdapter(CustomerSecurityMapper customerSecurityMapper) {
        this.customerSecurityMapper = customerSecurityMapper;
    }

    public String generateToken(Customer customer) {
        CustomerDetails customerDetails = customerSecurityMapper.customerToCustomerDetails(customer);
        SecretKey key = Keys.hmacShaKeyFor(this.secret.getBytes(StandardCharsets.UTF_8));

        return Jwts.builder()

                .issuer("Customer API")
                .subject(String.valueOf(customerDetails.getId()))
                .expiration(getExpiration())
                .signWith(key)
                .header()
                .add("typ", "JWT").and()
                .compact();
    }

    private Date getExpiration() {
        Date now = new Date();
        long expiryMillis = now.getTime() + this.expirationIsMillis;
        return new Date(expiryMillis);
    }

    public boolean isValid(String token) {
        try {
            SecretKey key = Keys.hmacShaKeyFor(this.secret.getBytes(StandardCharsets.UTF_8));

            Jwts.parser().verifyWith(key).build().parseSignedClaims(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    public UUID getUserIdFromToken(String token) {
        SecretKey key = Keys.hmacShaKeyFor(this.secret.getBytes(StandardCharsets.UTF_8));
        Claims claims = Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token).getPayload();
        String userId = claims.getSubject();
        return UUID.fromString(userId);

    }
}
