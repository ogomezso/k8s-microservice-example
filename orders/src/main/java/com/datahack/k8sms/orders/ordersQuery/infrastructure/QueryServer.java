package com.datahack.k8sms.orders.ordersQuery.infrastructure;

import com.datahack.k8sms.orders.domain.exception.OrderDoesNotExistsException;
import com.datahack.k8sms.orders.domain.model.OrderQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class QueryServer {
    private final QueryDas queryDas;

    @Autowired
    public QueryServer(QueryDas queryDas){
        this.queryDas = queryDas;
    }

    @Transactional
    public OrderQuery getOrder(String id) throws OrderDoesNotExistsException {
        return queryDas.getOrderQuery(id);
    }


}
