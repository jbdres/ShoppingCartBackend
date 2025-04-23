package com.devpractice.shoppingcartbackend.mapper;

import com.devpractice.shoppingcartbackend.dto.request.CategoryRequest;
import com.devpractice.shoppingcartbackend.dto.response.CategoryResponse;
import com.devpractice.shoppingcartbackend.model.Category;

public class CategoryMapper {

    public Category toEntity(CategoryRequest request) {
        return Category.builder()
                .name(request.name())
                .build();
    }

    public CategoryResponse toResponse(Category category) {
        return new CategoryResponse(
                category.getId(),
                category.getName()
        );
    }

}
