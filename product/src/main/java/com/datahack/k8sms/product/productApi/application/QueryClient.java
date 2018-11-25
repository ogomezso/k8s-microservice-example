package com.datahack.k8sms.product.productApi.application;


import com.datahack.k8sms.product.domain.exception.ProductDoesNotExistsException;
import com.datahack.k8sms.product.domain.model.Product;
import com.datahack.k8sms.product.productQuery.infrastructure.QueryServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class QueryClient {
    private final QueryServer queryServer;

    @Autowired
    public QueryClient(QueryServer queryServer) {
        this.queryServer = queryServer;
    }

    Product getProduct(String id) throws ProductDoesNotExistsException {
        return queryServer.getProduct(id);
    }

    Product modifyProduct(Product product) {
        return queryServer.modifyProduct(product);
    }

}
