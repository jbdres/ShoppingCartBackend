package com.devpractice.shoppingcartbackend.service.imp;

import com.devpractice.shoppingcartbackend.dto.request.ProductRequest;
import com.devpractice.shoppingcartbackend.dto.response.ProductResponse;
import com.devpractice.shoppingcartbackend.service.interfaces.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImp implements ProductService {

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        return null;
    }

    @Override
    public ProductResponse getProductById(Long id) {
        return null;
    }

    @Override
    public ProductResponse updateProduct(Long id, ProductRequest productRequest) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return List.of();
    }

    @Override
    public List<ProductResponse> getProductsByNameContainingIgnoreCase(String name) {
        return List.of();
    }

    @Override
    public List<ProductResponse> getProductsByBrandContainingIgnoreCase(String brand) {
        return List.of();
    }

    @Override
    public List<ProductResponse> getProductsByBrandContainingIgnoreCaseAndNameContainingIgnoreCase(String brand, String name) {
        return List.of();
    }

    @Override
    public List<ProductResponse> getProductsByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice) {
        return List.of();
    }

    @Override
    public List<ProductResponse> getProductsByDescriptionContainingIgnoreCase(String description) {
        return List.of();
    }

}
