package com.datahack.k8sms.orders.ordersApi.application;

import com.datahack.k8sms.orders.domain.model.OrderCommand;
import org.springframework.stereotype.Component;

@Component
class OrderValidator {

    Boolean validatePromo(OrderCommand orderCommand){

        //TODO Implment call to PromoQuery service to validate the availability of the promo taking in consideration the quantity requested.
        return true;
    }
}
