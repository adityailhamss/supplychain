package com.managing.supplychain.infrastructure.persistence.repository;

import com.managing.supplychain.infrastructure.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {
    Optional<ProductEntity> findBySku(String sku);
    List<ProductEntity> findByCategory(String category);
}
