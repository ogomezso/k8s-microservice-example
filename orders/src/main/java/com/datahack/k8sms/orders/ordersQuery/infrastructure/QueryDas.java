package com.datahack.k8sms.orders.ordersQuery.infrastructure;

import com.datahack.k8sms.orders.domain.model.OrderQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class QueryDas {

    private final QueryRepository queryRepository;
    private final DocumentMapper mapper;

    @Autowired
    QueryDas(QueryRepository queryRepository, DocumentMapper mapper) {
        this.queryRepository = queryRepository;
        this.mapper = mapper;
    }

    public OrderQuery saveQueryDocument(OrderQuery orderQuery){

        OrderQueryDocument document2Save = mapper.doamin2Document(orderQuery);
        OrderQueryDocument docSaved = queryRepository.save(document2Save);
        return mapper.document2Doamin(docSaved);
    }
}
