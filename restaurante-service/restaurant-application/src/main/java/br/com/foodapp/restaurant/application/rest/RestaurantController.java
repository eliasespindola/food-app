package br.com.foodapp.restaurant.application.rest;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "/restaurants", produces = "application/vnd.api.v1+json")
public class RestaurantController {

    @PostMapping
    public ResponseEntity<?> createRestaurant(@RequestBody @Valid String bla){
        return null;
    }

    //Colocar paginacao
    @GetMapping
    public ResponseEntity<?> findAllRestaurant(){
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable UUID id){
        return null;
    }

}
