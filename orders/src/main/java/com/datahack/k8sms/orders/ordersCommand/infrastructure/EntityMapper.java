package com.datahack.k8sms.orders.ordersCommand.infrastructure;

import com.datahack.k8sms.orders.domain.model.OrderCommand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface EntityMapper {

    OrderCommandEntity domain2Entity(OrderCommand orderCommand);
    OrderCommand entity2Domain(OrderCommandEntity entity);
}
