package com.madhav.ecomspring.service;

import com.madhav.ecomspring.dto.request.CategoryRequestDTO;
import com.madhav.ecomspring.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> getAll();

    Category getById(Long id);

    Category save(CategoryRequestDTO categoryRequestDTO);
}
