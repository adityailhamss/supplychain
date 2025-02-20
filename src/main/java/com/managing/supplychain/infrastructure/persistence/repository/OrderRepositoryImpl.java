package com.managing.supplychain.infrastructure.persistence.repository;

import com.managing.supplychain.domain.model.aggregates.Order;
import com.managing.supplychain.domain.repository.OrderRepository;
import com.managing.supplychain.domain.repository.OrderRepository;
import com.managing.supplychain.infrastructure.persistence.mapper.OrderInfrastructureMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {
    private final OrderJpaRepository OrderJpaRepository;
    private final OrderInfrastructureMapper OrderMapper;

    @Override
    public Order save(Order Order) {
        var entity = OrderMapper.toEntity(Order);
        var savedEntity = OrderJpaRepository.save(entity);
        return OrderMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Order> findById(Long id) {
        return OrderJpaRepository.findById(id)
                .map(OrderMapper::toDomain);
    }

    @Override
    public List<Order> findByStatus(String status) {
        return OrderJpaRepository.findByStatus(status).stream()
                .map(OrderMapper::toDomain)
                .toList();
    }

    @Override
    public List<Order> findAll() {
        return OrderJpaRepository.findAll().stream()
                .map(OrderMapper::toDomain)
                .toList();
    }

    @Override
    public void delete(Long id) {
        OrderJpaRepository.deleteById(id);
    }

//    @Override
//    public List<Order> findByCategory(String category) {
//        return OrderJpaRepository.findByCategory(category).stream()
//                .map(OrderMapper::toDomain)
//                .toList();
//    }
}
