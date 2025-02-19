package com.managing.supplychain.infrastructure.persistence.repository;

import com.managing.supplychain.domain.model.aggregates.Product;
import com.managing.supplychain.domain.repository.ProductRepository;
import com.managing.supplychain.infrastructure.persistence.mapper.ProductInfrastructureMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {
    private final ProductJpaRepository productJpaRepository;
    private final ProductInfrastructureMapper productMapper;

    @Override
    public Product save(Product product) {
        var entity = productMapper.toEntity(product);
        var savedEntity = productJpaRepository.save(entity);
        return productMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productJpaRepository.findById(id)
                .map(productMapper::toDomain);
    }

    @Override
    public Optional<Product> findBySku(String sku) {
        return productJpaRepository.findBySku(sku)
                .map(productMapper::toDomain);
    }

    @Override
    public List<Product> findAll() {
        return productJpaRepository.findAll().stream()
                .map(productMapper::toDomain)
                .toList();
    }

    @Override
    public void delete(Long id) {
        productJpaRepository.deleteById(id);
    }

    @Override
    public List<Product> findByCategory(String category) {
        return productJpaRepository.findByCategory(category).stream()
                .map(productMapper::toDomain)
                .toList();
    }
}
