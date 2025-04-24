package com.devpractice.shoppingcartbackend.service.interfaces;

import com.devpractice.shoppingcartbackend.dto.request.ProductRequest;
import com.devpractice.shoppingcartbackend.dto.response.ProductResponse;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    ProductResponse createProduct(ProductRequest productRequest);

    ProductResponse getProductById(Long id);

    ProductResponse updateProduct(Long id, ProductRequest productRequest);

    void deleteProduct(Long id);

    List<ProductResponse> getAllProducts();

    List<ProductResponse> getProductsByNameContainingIgnoreCase(String name);

    List<ProductResponse> getProductsByBrandContainingIgnoreCase(String brand);

    List<ProductResponse> getProductsByBrandContainingIgnoreCaseAndNameContainingIgnoreCase(String brand, String name);

    List<ProductResponse> getProductsByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);

    List<ProductResponse> getProductsByDescriptionContainingIgnoreCase(String description);

}
