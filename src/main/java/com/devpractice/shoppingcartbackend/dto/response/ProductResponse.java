package com.devpractice.shoppingcartbackend.dto.response;

import java.math.BigDecimal;

public record ProductResponse(

        Long id,
        String name,
        String brand,
        BigDecimal price,
        int quantity,
        String description

) {
}
