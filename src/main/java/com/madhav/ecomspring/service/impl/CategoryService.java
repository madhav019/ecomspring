package com.madhav.ecomspring.service.impl;

import com.madhav.ecomspring.dto.request.CategoryRequestDTO;
import com.madhav.ecomspring.entity.Category;
import com.madhav.ecomspring.exception.ResourceNotFoundException;
import com.madhav.ecomspring.mapper.CategoryMapper;
import com.madhav.ecomspring.repository.CategoryRepository;
import com.madhav.ecomspring.service.ICategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    final private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public Category getById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Category not found with id %d", id)));
    }

    public Category save(CategoryRequestDTO categoryRequestDTO) {
        Category category = CategoryMapper.toEntity(categoryRequestDTO);
        return categoryRepository.save(category);
    }
}
