package com.managing.supplychain.application.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderResponse {
    private Long id;
    private Long userId;
    private LocalDateTime orderDate;
    private String status;
    private BigDecimal totalAmount;
    private String shippingAddress;
    private String trackingNum;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
