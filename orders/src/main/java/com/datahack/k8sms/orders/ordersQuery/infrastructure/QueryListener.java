package com.datahack.k8sms.orders.ordersQuery.infrastructure;

import com.datahack.k8sms.orders.domain.model.CommandEvent;
import com.datahack.k8sms.orders.domain.model.OrderQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
class QueryListener implements ApplicationListener<CommandEvent> {

    private final OrderQueryBuilder orderQueryBuilder;
    private final QueryDas queryDas;

    QueryListener(OrderQueryBuilder orderQueryBuilder, QueryDas queryDas) {
        this.orderQueryBuilder = orderQueryBuilder;
        this.queryDas = queryDas;
    }

    @Override
    public void onApplicationEvent(CommandEvent commandEvent) {

        log.info("Query model receive command event: {}", commandEvent.getEventBody());
        OrderQuery orderQuery = orderQueryBuilder.build(commandEvent.getEventBody());
        queryDas.saveQueryDocument(orderQuery);
        log.info("Document Saved: {}", orderQuery);
    }

}
