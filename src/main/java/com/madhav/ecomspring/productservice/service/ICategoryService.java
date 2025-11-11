package com.madhav.ecomspring.productservice.service;

import com.madhav.ecomspring.productservice.dto.request.CategoryRequestDTO;
import com.madhav.ecomspring.productservice.dto.response.CategoryWithProductsResponseDTO;
import com.madhav.ecomspring.productservice.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> getAll();

    Category getById(Long id);

    Category save(CategoryRequestDTO categoryRequestDTO);

    CategoryWithProductsResponseDTO getCategoryWithProducts(Long categoryId);
}
