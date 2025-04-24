package com.devpractice.shoppingcartbackend.service.imp;

import com.devpractice.shoppingcartbackend.dto.request.ProductRequest;
import com.devpractice.shoppingcartbackend.dto.response.ProductResponse;
import com.devpractice.shoppingcartbackend.exception.DatabaseException;
import com.devpractice.shoppingcartbackend.exception.ResourceNotFoundException;
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
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));
        return productMapper.toResponse(product);
    }

    @Override
    @Transactional
    public ProductResponse updateProduct(Long id, ProductRequest productRequest) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));
        product.setName(productRequest.name());
        product.setBrand(productRequest.brand());
        product.setPrice(productRequest.price());
        product.setQuantity(productRequest.quantity());
        product.setDescription(productRequest.description());
        try {
            Product savedProduct = productRepository.save(product);
            return productMapper.toResponse(savedProduct);
        } catch (DataAccessException e) {
            throw new DatabaseException("Error while updating product to the database");
        }
    }

    @Override
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Product with id " + id + " not found");
        }
        try {
            productRepository.deleteById(id);
        } catch (DataAccessException e) {
            throw new DatabaseException("Error while deleting product from the database");
        }
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toResponse)
                .toList();
    }

    @Override
    public List<ProductResponse> getProductsByNameContainingIgnoreCase(String name) {
        return productRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(productMapper::toResponse)
                .toList();
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
