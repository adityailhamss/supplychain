package com.managing.supplychain.domain.model.aggregates;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
public class Order {
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
