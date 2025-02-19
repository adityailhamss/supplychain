package com.managing.supplychain.application.service.impl;

import com.managing.supplychain.application.dto.request.CreateProductRequest;
import com.managing.supplychain.application.dto.request.UpdateProductRequest;
import com.managing.supplychain.application.dto.response.ProductResponse;
import com.managing.supplychain.application.mapper.ProductApplicationMapper;
import com.managing.supplychain.application.service.ProductService;
import com.managing.supplychain.common.exception.ResourceNotFoundException;
import com.managing.supplychain.domain.model.aggregates.Product;
import com.managing.supplychain.domain.repository.ProductRepository;
import com.managing.supplychain.domain.service.ProductDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductDomainService productDomainService;
    private final ProductApplicationMapper productMapper;

    @Override
    public ProductResponse createProduct(CreateProductRequest request) {
        Product product = productMapper.toProduct(request);
        productDomainService.validateProduct(product);
        Product savedProduct = productRepository.save(product);
        return productMapper.toResponse(savedProduct);
    }

    @Override
    public ProductResponse updateProduct(Long id, UpdateProductRequest request) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        productMapper.updateProduct(existingProduct, request); // Updates existing product in place

        productDomainService.validateProduct(existingProduct);
        Product savedProduct = productRepository.save(existingProduct);
        return productMapper.toResponse(savedProduct);
    }


    @Override
    @Transactional(readOnly = true)
    public ProductResponse getProduct(Long id) {
        return productRepository.findById(id)
                .map(productMapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream()
                .map(productMapper::toResponse)
                .toList();
    }

    @Override
    public void deleteProduct(Long id) {
        if (!productRepository.findById(id).isPresent()) {
            throw new ResourceNotFoundException("Product not found");
        }
        productRepository.delete(id);
    }

//    @Override
//    public ProductResponse updateStock(Long id, int quantity) {
//        Product product = productRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
//
////        productDomainService.updateProductStock(product, quantity);
//        return productMapper.toResponse(product);
//    }
}
