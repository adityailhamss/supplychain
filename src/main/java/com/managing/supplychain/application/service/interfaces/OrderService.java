package com.managing.supplychain.application.service.interfaces;

import com.managing.supplychain.application.dto.request.CreateOrderRequest;
import com.managing.supplychain.application.dto.request.UpdateOrderRequest;
import com.managing.supplychain.application.dto.response.OrderResponse;

import java.util.List;

public interface OrderService {
    OrderResponse createOrder(CreateOrderRequest request);
    OrderResponse updateOrder(Long id, UpdateOrderRequest request);
    OrderResponse getOrder(Long id);
    List<OrderResponse> getAllOrders();
    void deleteOrder(Long id);
}
