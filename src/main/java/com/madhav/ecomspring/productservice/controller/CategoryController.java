package com.madhav.ecomspring.productservice.controller;

import com.madhav.ecomspring.productservice.dto.request.CategoryRequestDTO;
import com.madhav.ecomspring.productservice.dto.response.CategoryResponseDTO;
import com.madhav.ecomspring.productservice.dto.response.CategoryWithProductsResponseDTO;
import com.madhav.ecomspring.productservice.entity.Category;
import com.madhav.ecomspring.productservice.mapper.CategoryMapper;
import com.madhav.ecomspring.productservice.service.ICategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final ICategoryService categoryService;

    CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<CategoryResponseDTO> getAll() {
        List<Category> categories = categoryService.getAll();
        return categories.stream()
                .map(CategoryMapper::toDTO)
                .toList();
    }

    @GetMapping("{id}")
    public CategoryResponseDTO getById(@PathVariable Long id) {
        Category category = categoryService.getById(id);
        return CategoryMapper.toDTO(category);
    }

    @PostMapping
    public CategoryResponseDTO save(@RequestBody CategoryRequestDTO categoryRequestDTO) {
        Category category = categoryService.save(categoryRequestDTO);
        return CategoryMapper.toDTO(category);
    }

    @GetMapping("/{categoryId}/products")
    public CategoryWithProductsResponseDTO getAllByCategory(@PathVariable Long categoryId) {
        return categoryService.getCategoryWithProducts(categoryId);
    }
}
