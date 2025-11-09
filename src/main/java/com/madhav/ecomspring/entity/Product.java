package com.madhav.ecomspring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product extends BaseEntity {
    private String image;
    private String color;
    private Long price;
    private String description;
    private Long discount;
    private String model;
    private String title;
    private String brand;
    private boolean popular;

    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    private Category category;
}
