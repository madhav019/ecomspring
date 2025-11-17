package com.madhav.ecomspring.productservice.controller;

import com.madhav.ecomspring.productservice.advice.GlobalExceptionHandler;
import com.madhav.ecomspring.productservice.entity.Category;
import com.madhav.ecomspring.productservice.service.impl.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class CategoryControllerTest {

    @Mock
    private CategoryService categoryService;

    @InjectMocks
    private CategoryController categoryController;

    private MockMvc mockMvc;

    private Category category1, category2, category3;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(categoryController)
                .setControllerAdvice(GlobalExceptionHandler.class)
                .build();

        category1 = Category.builder().id(1L).name("Electronics").build();
        category2 = Category.builder().id(2L).name("Books").build();
        category3 = Category.builder().id(3L).name("Clothing").build();
    }

    @Test
    @DisplayName("GET /api/category should return all categories successfully")
    void getAllCategories_shouldReturnAllCategories() throws Exception {
        // Arrange: setup mock data and behavior
        List<Category> categories = List.of(category1, category2, category3);
        when(categoryService.getAll()).thenReturn(categories);

        // Act: call the service method
        mockMvc.perform(get("/api/category"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(categories.size()))
                .andExpect(jsonPath("$[0].name").value("Electronics"))
                .andExpect(jsonPath("$[1].name").value("Books"))
                .andExpect(jsonPath("$[2].name").value("Clothing"));

        // Assert: verify the results
        verify(categoryService).getAll();
    }

}
