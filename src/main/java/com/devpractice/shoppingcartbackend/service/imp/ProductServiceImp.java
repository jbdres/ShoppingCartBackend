package com.devpractice.shoppingcartbackend.service.imp;

import com.devpractice.shoppingcartbackend.dto.request.ProductRequest;
import com.devpractice.shoppingcartbackend.dto.response.ProductResponse;
import com.devpractice.shoppingcartbackend.exception.DatabaseException;
import com.devpractice.shoppingcartbackend.mapper.ProductMapper;
import com.devpractice.shoppingcartbackend.model.Product;
import com.devpractice.shoppingcartbackend.repository.ProductRepository;
import com.devpractice.shoppingcartbackend.service.interfaces.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    @Transactional
    public ProductResponse createProduct(ProductRequest productRequest) {
        try {
            Product product = productMapper.toEntity(productRequest);
            Product savedProduct = productRepository.save(product);
            return productMapper.toResponse(savedProduct);
        } catch (DataAccessException e) {
            throw new DatabaseException("Error while saving product to the database");
        }
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
