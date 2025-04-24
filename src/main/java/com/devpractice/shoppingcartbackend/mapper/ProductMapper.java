package com.devpractice.shoppingcartbackend.mapper;

import com.devpractice.shoppingcartbackend.dto.request.ProductRequest;
import com.devpractice.shoppingcartbackend.dto.response.ProductResponse;
import com.devpractice.shoppingcartbackend.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toEntity(ProductRequest productRequest) {
        return Product.builder()
                .name(productRequest.name())
                .brand(productRequest.brand())
                .price(productRequest.price())
                .quantity(productRequest.quantity())
                .description(productRequest.description())
                .build();
    }

    public ProductResponse toResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getBrand(),
                product.getPrice(),
                product.getQuantity(),
                product.getDescription()
        );
    }

}
