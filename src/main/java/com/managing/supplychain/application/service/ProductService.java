package com.managing.supplychain.application.service;

import com.managing.supplychain.application.dto.request.CreateProductRequest;
import com.managing.supplychain.application.dto.request.UpdateProductRequest;
import com.managing.supplychain.application.dto.response.ProductResponse;
import java.util.List;

public interface ProductService {
    ProductResponse createProduct(CreateProductRequest request);
    ProductResponse updateProduct(Long id, UpdateProductRequest request);
    ProductResponse getProduct(Long id);
    List<ProductResponse> getAllProducts();
    void deleteProduct(Long id);
//    ProductResponse updateStock(Long id, int quantity);
}
