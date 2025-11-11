package com.madhav.ecomspring.productservice.mapper;

import com.madhav.ecomspring.productservice.dto.request.CategoryRequestDTO;
import com.madhav.ecomspring.productservice.dto.response.CategoryResponseDTO;
import com.madhav.ecomspring.productservice.entity.Category;

public class CategoryMapper {

    public static Category toEntity(CategoryRequestDTO categoryRequestDTO) {
        return Category.builder()
                .name(categoryRequestDTO.getName())
                .build();
    }

    public static Category toEntityFromResponse(CategoryResponseDTO categoryRequestDTO) {
        return Category.builder()
                .name(categoryRequestDTO.getName())
                .build();
    }

    public static CategoryResponseDTO toDTO(Category category) {
        return CategoryResponseDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

}
