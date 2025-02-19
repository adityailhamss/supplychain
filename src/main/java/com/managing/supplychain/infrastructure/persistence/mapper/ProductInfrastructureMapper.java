package com.managing.supplychain.infrastructure.persistence.mapper;

import org.mapstruct.Mapper;
import com.managing.supplychain.domain.model.aggregates.Product;
import com.managing.supplychain.infrastructure.persistence.entity.ProductEntity;

@Mapper(componentModel = "spring", implementationName = "PersistenceProductMapperImpl")
public interface ProductInfrastructureMapper {
    ProductEntity toEntity(Product product);
    
    Product toDomain(ProductEntity entity);
}
