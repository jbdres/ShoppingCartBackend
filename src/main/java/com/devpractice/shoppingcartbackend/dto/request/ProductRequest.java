package com.devpractice.shoppingcartbackend.dto.request;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record ProductRequest(

        @NotBlank(message = "Name is required")
        @Size(min = 3, max = 100, message = "Name must be between 3 and 100 characters")
        String name,

        @NotBlank(message = "Brand is required")
        @Size(min = 3, max = 100, message = "Brand must be between 3 and 100 characters")
        String brand,

        @NotNull(message = "Price is required")
        @DecimalMin(value = "0.0", message = "Price must be greater or equals than 0")
        @Digits(integer = 8, fraction = 2, message = "Price must be less than 8 digits and 2 decimal places")
        BigDecimal price,

        @NotNull(message = "Quantity is required")
        @Min(value = 0, message = "Quantity must be greater or equals than 0")
        int quantity,

        @NotBlank(message = "Description is required")
        @Size(max = 1000, message = "Description must be less than 1000 characters")
        String description

) {
}
