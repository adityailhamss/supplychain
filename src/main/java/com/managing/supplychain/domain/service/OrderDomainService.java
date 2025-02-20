package com.managing.supplychain.domain.service;

import com.managing.supplychain.domain.model.aggregates.Order;
import com.managing.supplychain.domain.model.aggregates.Product;
import com.managing.supplychain.domain.repository.OrderRepository;
import com.managing.supplychain.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderDomainService {
    private final OrderRepository OrderRepository;
    public void validateOrder(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }

        BigDecimal totalAmount = Optional.ofNullable(order.getTotalAmount())
                .orElse(BigDecimal.ZERO);
        System.out.println("DEBUG: Order total amount = " + totalAmount);

        if (totalAmount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Order amount must be greater than zero");
        }
    }

}
