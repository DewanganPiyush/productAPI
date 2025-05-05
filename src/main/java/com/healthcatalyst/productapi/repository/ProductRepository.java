package com.healthcatalyst.productapi.repository;

import com.healthcatalyst.productapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
