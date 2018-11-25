package com.datahack.k8sms.orders.ordersQuery.infrastructure;

import com.datahack.k8sms.orders.domain.model.OrderQuery;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DocumentMapper {

    OrderQueryDocument doamin2Document(OrderQuery orderQuery);
    OrderQuery document2Doamin(OrderQueryDocument orderQueryDocument);
}
