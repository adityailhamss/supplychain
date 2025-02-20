package com.managing.supplychain.domain.repository;

import com.managing.supplychain.domain.model.aggregates.Order;
import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    Order save(Order order);
    Optional<Order> findById(Long id);
    List<Order> findAll();
    void delete(Long id);
    List<Order> findByStatus(String status);
}
