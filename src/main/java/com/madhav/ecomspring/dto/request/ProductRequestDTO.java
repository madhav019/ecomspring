package com.madhav.ecomspring.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequestDTO {
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
