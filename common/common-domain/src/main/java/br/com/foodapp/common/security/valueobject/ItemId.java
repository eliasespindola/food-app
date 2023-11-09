package br.com.foodapp.common.security.valueobject;

import br.com.foodapp.common.security.entity.BaseEntity;

public class ItemId extends BaseId<Long> {
    protected ItemId(Long value) {
        super(value);
    }
}
