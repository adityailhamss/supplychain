package com.managing.supplychain.domain.model.aggregates;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class Product {
    private Long id;
    private String name;
    private String description;
    private String sku;
    private BigDecimal basePrice;
    private String category;
    private Integer supplierId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}