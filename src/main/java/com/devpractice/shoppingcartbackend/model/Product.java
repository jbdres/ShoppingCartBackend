package com.devpractice.shoppingcartbackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    @Getter
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "name", nullable = false, length = 100)
    @Getter
    @Setter
    private String name;

    @NotBlank(message = "Brand is mandatory")
    @Column(name = "brand", nullable = false, length = 100)
    @Getter
    @Setter
    private String brand;

    @NotNull(message = "Price is mandatory")
    @DecimalMin(value = "0.0", message = "Price must be greater or equals than 0")
    @Digits(integer = 8, fraction = 2, message = "Price must be less than 8 digits and 2 decimal places")
    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    @Getter
    @Setter
    private BigDecimal price;

    @NotNull(message = "Quantity is mandatory")
    @Min(value = 0, message = "Quantity must be greater or equals than 0")
    @Column(name = "quantity", nullable = false)
    @Getter
    @Setter
    private int quantity;

    @NotBlank(message = "Description is mandatory")
    @Size(max = 1000, message = "Description must be less than 1000 characters")
    @Column(name = "description", length = 1000)
    @Getter
    @Setter
    private String description;

}
