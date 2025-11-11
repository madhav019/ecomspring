package com.madhav.ecomspring.productservice.controller;

import com.madhav.ecomspring.productservice.dto.request.ProductRequestDTO;
import com.madhav.ecomspring.productservice.dto.response.ProductResponseDTO;
import com.madhav.ecomspring.productservice.entity.Product;
import com.madhav.ecomspring.productservice.mapper.ProductMapper;
import com.madhav.ecomspring.productservice.service.IProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductResponseDTO> getAll() {
        return productService.getAll()
                .stream()
                .map(ProductMapper::toDto)
                .toList();
    }

    @GetMapping("{id}")
    public ProductResponseDTO getById(@PathVariable Long id) {
        Product product = productService.getById(id);
        return ProductMapper.toDto(product);
    }

    @PostMapping
    public ProductResponseDTO save(@RequestBody ProductRequestDTO productRequestDTO) {
        Product product = productService.save(productRequestDTO);
        return ProductMapper.toDto(product);
    }

    @GetMapping("/search")
    public List<ProductResponseDTO> search(@RequestParam(name = "q") String keyword) {
        return productService.searchFullText(keyword)
                .stream()
                .map(ProductMapper::toDto)
                .toList();
    }

}
