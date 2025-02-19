package com.managing.supplychain.domain.repository;

import com.managing.supplychain.domain.model.aggregates.Product;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Product save(Product product);
    Optional<Product> findById(Long id);
    Optional<Product> findBySku(String sku);
    List<Product> findAll();
    void delete(Long id);
    List<Product> findByCategory(String category);
}