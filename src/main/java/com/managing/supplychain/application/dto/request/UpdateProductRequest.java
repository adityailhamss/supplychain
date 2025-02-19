package com.managing.supplychain.application.dto.request;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class UpdateProductRequest {
    private String name;
    private String description;
    private String sku;
    private BigDecimal basePrice;
    private String category;
    private Integer supplierId;
}

