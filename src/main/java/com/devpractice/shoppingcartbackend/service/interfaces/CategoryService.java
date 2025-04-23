package com.devpractice.shoppingcartbackend.service.interfaces;

import com.devpractice.shoppingcartbackend.dto.request.CategoryRequest;
import com.devpractice.shoppingcartbackend.dto.response.CategoryResponse;

import java.util.List;

public interface CategoryService {

    CategoryResponse createCategory(CategoryRequest categoryRequest);

    CategoryResponse getCategoryById(Long id);

    List<CategoryResponse> getAllCategories();

    CategoryResponse updateCategory(Long id, CategoryRequest categoryRequest);

    void deleteCategoryById(Long id);

}
