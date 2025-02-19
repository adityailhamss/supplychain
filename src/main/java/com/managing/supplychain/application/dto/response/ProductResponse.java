package com.managing.supplychain.application.dto.response;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private String sku;
    private BigDecimal basePrice;
    private String category;
    private Long supplierId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}