package com.managing.supplychain.application.service.impl;

import com.managing.supplychain.application.dto.request.CreateOrderRequest;
import com.managing.supplychain.application.dto.request.UpdateOrderRequest;
import com.managing.supplychain.application.dto.response.OrderResponse;
import com.managing.supplychain.application.mapper.OrderApplicationMapper;
import com.managing.supplychain.application.service.interfaces.OrderService;
import com.managing.supplychain.common.exception.ResourceNotFoundException;
import com.managing.supplychain.domain.model.aggregates.Order;
import com.managing.supplychain.domain.repository.OrderRepository;
import com.managing.supplychain.domain.service.OrderDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService{
    private final OrderRepository OrderRepository;
    private final OrderDomainService OrderDomainService;
    private final OrderApplicationMapper OrderMapper;

    @Override
    public OrderResponse createOrder(CreateOrderRequest request) {
        Order Order = OrderMapper.toOrder(request);
        OrderDomainService.validateOrder(Order);
        Order savedOrder = OrderRepository.save(Order);
        return OrderMapper.toResponse(savedOrder);
    }

    @Override
    public OrderResponse updateOrder(Long id, UpdateOrderRequest request) {
        Order existingOrder = OrderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));

        OrderMapper.updateOrder(existingOrder, request);

        OrderDomainService.validateOrder(existingOrder);
        Order savedOrder = OrderRepository.save(existingOrder);
        return OrderMapper.toResponse(savedOrder);
    }


    @Override
    @Transactional(readOnly = true)
    public OrderResponse getOrder(Long id) {
        return OrderRepository.findById(id)
                .map(OrderMapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderResponse> getAllOrders() {
        return OrderRepository.findAll().stream()
                .map(OrderMapper::toResponse)
                .toList();
    }

    @Override
    public void deleteOrder(Long id) {
        if (!OrderRepository.findById(id).isPresent()) {
            throw new ResourceNotFoundException("Order not found");
        }
        OrderRepository.delete(id);
    }
}
