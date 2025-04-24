package com.devpractice.shoppingcartbackend.repository;

import com.devpractice.shoppingcartbackend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByNameContainingIgnoreCase(String name);

    List<Product> findByBrandContainingIgnoreCase(String brand);

    List<Product> findByBrandContainingIgnoreCaseAndNameContainingIgnoreCase(String brand, String name);

    List<Product> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);

    List<Product> findByDescriptionContainingIgnoreCase(String description);

}
