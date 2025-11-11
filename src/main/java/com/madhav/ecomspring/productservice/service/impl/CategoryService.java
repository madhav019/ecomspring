package com.madhav.ecomspring.productservice.service.impl;

import com.madhav.ecomspring.productservice.dto.request.CategoryRequestDTO;
import com.madhav.ecomspring.productservice.dto.response.CategoryWithProductsResponseDTO;
import com.madhav.ecomspring.productservice.dto.response.ProductResponseDTO;
import com.madhav.ecomspring.productservice.entity.Category;
import com.madhav.ecomspring.productservice.exception.ResourceNotFoundException;
import com.madhav.ecomspring.productservice.mapper.CategoryMapper;
import com.madhav.ecomspring.productservice.mapper.ProductMapper;
import com.madhav.ecomspring.productservice.repository.CategoryRepository;
import com.madhav.ecomspring.productservice.service.ICategoryService;
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

    public CategoryWithProductsResponseDTO getCategoryWithProducts(Long id) {
        Category category = categoryRepository.findByIdWithProducts(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id " + id));

        List<ProductResponseDTO> products = category.getProducts()
                .stream()
                .map(ProductMapper::toDto)
                .toList();

        return CategoryWithProductsResponseDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .products(products)
                .build();
    }
}
