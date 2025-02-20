package com.managing.supplychain.infrastructure.persistence.repository;

import com.managing.supplychain.infrastructure.persistence.entity.OrderEntity;
import com.managing.supplychain.infrastructure.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface OrderJpaRepository extends JpaRepository<OrderEntity, Long> {
    List<OrderEntity> findByStatus(String status);
//    List<OrderEntity> findByCategory(String category);
}
