package com.datahack.k8sms.orders.ordersQuery.infrastructure;

import com.datahack.k8sms.orders.domain.exception.OrderDoesNotExistsException;
import com.datahack.k8sms.orders.domain.model.OrderQuery;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

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

    public OrderQuery getOrderQuery(String id) throws OrderDoesNotExistsException {
        Optional<OrderQueryDocument> orderQuery = queryRepository.findById(id);
        return orderQuery.map(mapper::document2Doamin)
                .orElseThrow(() -> new OrderDoesNotExistsException("Order not exists"));
    }

    public void deleteOrderQuery(String id){
        queryRepository.deleteById(id);
        return;
    }
}
