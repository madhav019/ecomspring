package com.madhav.ecomspring.mapper;

import com.madhav.ecomspring.dto.request.ProductRequestDTO;
import com.madhav.ecomspring.dto.response.ProductResponseDTO;
import com.madhav.ecomspring.entity.Category;
import com.madhav.ecomspring.entity.Product;

public class ProductMapper {

    public static Product toEntity(ProductRequestDTO productRequestDTO, Category category) {
        return Product.builder()
                .brand(productRequestDTO.getBrand())
                .model(productRequestDTO.getModel())
                .color(productRequestDTO.getColor())
                .description(productRequestDTO.getDescription())
                .discount(productRequestDTO.getDiscount())
                .image(productRequestDTO.getImage())
                .price(productRequestDTO.getPrice())
                .title(productRequestDTO.getTitle())
                .popular(productRequestDTO.isPopular())
                .category(category)
                .build();
    }

    public static ProductResponseDTO toDto(Product product) {
        return ProductResponseDTO.builder()
                .brand(product.getBrand())
                .model(product.getModel())
                .color(product.getColor())
                .description(product.getDescription())
                .discount(product.getDiscount())
                .image(product.getImage())
                .price(product.getPrice())
                .title(product.getTitle())
                .popular(product.isPopular())
                .id(product.getId())
                .categoryId(product.getCategory().getId())
                .build();
    }

}
