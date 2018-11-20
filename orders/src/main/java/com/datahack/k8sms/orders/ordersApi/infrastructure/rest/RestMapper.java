package com.datahack.k8sms.orders.ordersApi.infrastructure.rest;

import com.datahack.k8sms.orders.domain.model.OrderCommand;
import com.datahack.k8sms.orders.ordersApi.infrastructure.rest.model.ClientApiRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestMapper {

    OrderCommand request2Domain(ClientApiRequest request);
}
