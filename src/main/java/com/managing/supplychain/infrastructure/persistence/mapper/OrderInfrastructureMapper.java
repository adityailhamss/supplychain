package com.managing.supplychain.infrastructure.persistence.mapper;

import org.mapstruct.Mapper;
import com.managing.supplychain.domain.model.aggregates.Order;
import com.managing.supplychain.infrastructure.persistence.entity.OrderEntity;

@Mapper(componentModel = "spring", implementationName = "PersistenceOrderMapperImpl")
public interface OrderInfrastructureMapper {
    OrderEntity toEntity(Order order);

    Order toDomain(OrderEntity entity);
}
