package com.managing.supplychain.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import com.managing.supplychain.domain.model.aggregates.Product;
import com.managing.supplychain.application.dto.request.CreateProductRequest;
import com.managing.supplychain.application.dto.request.UpdateProductRequest;
import com.managing.supplychain.application.dto.response.ProductResponse;

@Mapper(componentModel = "spring", implementationName = "ApplicationProductMapperImpl")
public interface ProductApplicationMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Product toProduct(CreateProductRequest request);

    ProductResponse toResponse(Product product);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateProduct(@MappingTarget Product product, UpdateProductRequest request);
}