package com.managing.supplychain.application.mapper;

import com.managing.supplychain.application.dto.request.UpdateOrderRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import com.managing.supplychain.domain.model.aggregates.Order;
import com.managing.supplychain.application.dto.request.CreateOrderRequest;
import com.managing.supplychain.application.dto.response.OrderResponse;

@Mapper(componentModel = "spring", implementationName = "ApplicationOrderMapperImpl")
public interface OrderApplicationMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Order toOrder(CreateOrderRequest request);

    OrderResponse toResponse(Order order);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateOrder(@MappingTarget Order order, UpdateOrderRequest request);
}
