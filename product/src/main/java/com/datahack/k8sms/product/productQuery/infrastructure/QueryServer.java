package com.datahack.k8sms.product.productQuery.infrastructure;



import com.datahack.k8sms.product.domain.exception.ProductDoesNotExistsException;
import com.datahack.k8sms.product.domain.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class QueryServer {
    private final QueryDas queryDas;

    @Autowired
    public QueryServer(QueryDas queryDas) {
        this.queryDas = queryDas;
    }

    @Transactional
    public Product getProduct(String id) throws ProductDoesNotExistsException {
        return queryDas.getProduct(id);
    }

    @Transactional
    public Product modifyProduct(Product product) {
        return queryDas.modifyProduct(product);
    }
}
