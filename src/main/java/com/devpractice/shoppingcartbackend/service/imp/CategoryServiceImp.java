package com.devpractice.shoppingcartbackend.service.imp;

import com.devpractice.shoppingcartbackend.dto.request.CategoryRequest;
import com.devpractice.shoppingcartbackend.dto.response.CategoryResponse;
import com.devpractice.shoppingcartbackend.exception.DatabaseException;
import com.devpractice.shoppingcartbackend.exception.ResourceConflictException;
import com.devpractice.shoppingcartbackend.mapper.CategoryMapper;
import com.devpractice.shoppingcartbackend.model.Category;
import com.devpractice.shoppingcartbackend.repository.CategoryRepository;
import com.devpractice.shoppingcartbackend.service.interfaces.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImp implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryResponse createCategory(CategoryRequest categoryRequest) {
        if (categoryRepository.existsByName(categoryRequest.name())) {
            throw new ResourceConflictException("Category with name " + categoryRequest.name() + " already exists");
        }
        try {
            Category category = categoryMapper.toEntity(categoryRequest);
            Category savedCategory = categoryRepository.save(category);
            return categoryMapper.toResponse(savedCategory);
        } catch (DataAccessException e) {
            throw new DatabaseException("Error while saving category to the database");
        }
    }

    @Override
    public CategoryResponse getCategoryById(Long id) {
        return null;
    }

    @Override
    public List<CategoryResponse> getAllCategories() {
        return List.of();
    }

    @Override
    public CategoryResponse updateCategory(Long id, CategoryRequest categoryRequest) {
        return null;
    }

    @Override
    public void deleteCategoryById(Long id) {

    }
}
