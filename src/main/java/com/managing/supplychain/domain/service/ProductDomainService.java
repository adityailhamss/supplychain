package com.managing.supplychain.domain.service;

import com.managing.supplychain.domain.model.aggregates.Product;
import com.managing.supplychain.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ProductDomainService {
    private final ProductRepository productRepository;

    public void validateProduct(Product product) {
        if (product.getBasePrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Product price must be greater than zero");
        }
        // if (product.getStockQuantity() < 0) {
        //     throw new IllegalArgumentException("Stock quantity cannot be negative");
        // }
    }

//    public void updateProductStock(Product product, int quantity) {
//        product.updateStock(quantity);
//        productRepository.save(product);
//    }
}
