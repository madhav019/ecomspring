package com.madhav.ecomspring.productservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponseDTO {
    private Long id;
    private String image;
    private String color;
    private Long price;
    private String description;
    private Long discount;
    private String model;
    private String title;
    private String brand;
    private boolean popular;
    private Long categoryId;
}
