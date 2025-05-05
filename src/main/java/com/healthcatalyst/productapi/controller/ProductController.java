package com.healthcatalyst.productapi.controller;

import com.healthcatalyst.productapi.entity.Product;
import com.healthcatalyst.productapi.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/get-product")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }
}
