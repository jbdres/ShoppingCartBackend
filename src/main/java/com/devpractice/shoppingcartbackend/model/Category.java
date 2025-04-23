package com.devpractice.shoppingcartbackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "category")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    @Getter
    Long id;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "name", nullable = false, unique = true, length = 100)
    @Getter
    @Setter
    String name;

}
