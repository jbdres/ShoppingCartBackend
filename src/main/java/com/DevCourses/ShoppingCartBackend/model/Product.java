package com.DevCourses.ShoppingCartBackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String brand;
    private BigDecimal price;
    private int inventory;
    private String description;

    /* If a product is deleted, the relationship with the Category entity
     *  will be deleted, but not the category type record.
     * */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(
            mappedBy = "product",
            /*
             * Enables cascading operations so that changes made to the
             * parent entity (such as persist, merge, remove, refresh,
             * detach) are automatically applied to the associated child
             * entities.
             * */
            cascade = CascadeType.ALL,
            /* Ensures that if a child entity is removed from the collection
             * in the parent entity, it will also be deleted from the
             * database (if it is no longer referenced elsewhere). This
             * helps maintain data integrity by automatically cleaning up
             * orphaned records.
             * */
            orphanRemoval = true
    )
    private List<Image> images;

}
