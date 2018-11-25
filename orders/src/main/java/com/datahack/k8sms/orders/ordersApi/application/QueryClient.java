package com.datahack.k8sms.orders.ordersApi.application;

import com.datahack.k8sms.orders.domain.exception.OrderDoesNotExistsException;
import com.datahack.k8sms.orders.domain.model.OrderQuery;
import com.datahack.k8sms.orders.ordersQuery.infrastructure.QueryServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class QueryClient {
    private final QueryServer queryServer;

    @Autowired
    public QueryClient(QueryServer queryServer){
        this.queryServer = queryServer;
    }

    OrderQuery getOrder(String id) throws OrderDoesNotExistsException {
        return queryServer.getOrder(id);
    }


}
