package com.madhav.ecomspring.productservice.service;

import com.madhav.ecomspring.productservice.dto.request.CategoryRequestDTO;
import com.madhav.ecomspring.productservice.entity.Category;
import com.madhav.ecomspring.productservice.repository.CategoryRepository;
import com.madhav.ecomspring.productservice.service.impl.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    private Category category1, category2, category3;
    private CategoryRequestDTO categoryRequestDTO;

    @BeforeEach
    void setup() {
        category1 = Category.builder()
                .id(1L)
                .name("Electronics")
                .build();

        category2 = Category.builder()
                .id(2L)
                .name("Books")
                .build();

        category3 = Category.builder()
                .id(3L)
                .name("Clothing")
                .build();

        categoryRequestDTO = CategoryRequestDTO.builder()
                .name("Electronics")
                .build();
    }

    @Test
    @DisplayName("getAll() should return all categories successfully")
    void getAllCategories_shouldReturnAllCategories() {

        // Arrange: setup mock data and behavior
        List<Category> categories = List.of(category1, category2, category3);
        when(categoryRepository.findAll()).thenReturn(categories);

        // Act: call the method under test
        List<Category> result = categoryService.getAll();

        // Assert: verify the results
        assertNotNull(result);
        assertEquals(result.size(), 3);
        assertEquals(result.get(0).getName(), "Electronics");
        assertEquals(result.get(1).getName(), "Books");

        verify(categoryRepository, times(1)).findAll();
        verifyNoMoreInteractions(categoryRepository);
    }

    @Test
    @DisplayName("getByAId() should return category for a given id successfully")
    void getByIdCategory_shouldReturnCategoryById() {

        // Arrange
        when(categoryRepository.findById(1L)).thenReturn(Optional.of(category1));

        // Act
        Category result = categoryService.getById(1L);

        // Assert
        assertNotNull(result);
        assertEquals(result.getId(), 1L);
        assertEquals(result.getName(), "Electronics");

        verify(categoryRepository, times(1)).findById(1L);
        verifyNoMoreInteractions(categoryRepository);
    }

    @Test
    @DisplayName("save() should save category and return it successfully")
    void saveCategory_shouldSaveAndReturnCategory() {

        // Arrange
        when(categoryRepository.save(any(Category.class))).thenReturn(category1);

        // Act
        Category result = categoryService.save(categoryRequestDTO);

        // Assert
        assertNotNull(result);
        assertEquals(result.getId(), 1L);
        assertEquals(result.getName(), "Electronics");

        verify(categoryRepository).save(any(Category.class));
        verifyNoMoreInteractions(categoryRepository);

    }

}
