package com.madhav.ecomspring.productservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category extends BaseEntity {
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
