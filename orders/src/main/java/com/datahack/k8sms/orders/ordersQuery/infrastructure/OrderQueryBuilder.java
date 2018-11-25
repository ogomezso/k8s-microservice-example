package com.datahack.k8sms.orders.ordersQuery.infrastructure;

import com.datahack.k8sms.orders.domain.model.OrderCommand;
import com.datahack.k8sms.orders.domain.model.OrderQuery;
import org.springframework.stereotype.Component;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import java.util.Date;

@Component
class OrderQueryBuilder {

    private final PodamFactory podamFactory = new PodamFactoryImpl();


    OrderQuery build(OrderCommand eventBody) {

        //TODO get client and product Data from a master client info datasource and promo Query API
        OrderQuery response = podamFactory.manufacturePojo(OrderQuery.class);
        response.setId(eventBody.getId());
        response.setClientId(eventBody.getClientId());
        response.setPromoId(eventBody.getPromoId());

        //TODO, FINISH
        response.getProducts().clear();


        response.setCreationDate(new Date());

        return response;
    }
}
