package com.datahack.k8sms.product.productQuery.infrastructure;


import com.datahack.k8sms.product.domain.model.ProductEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class QueryListener implements ApplicationListener<ProductEvent>
{
    private final QueryDas queryDas;

    QueryListener(QueryDas queryDas) {
        this.queryDas = queryDas;
    }

    @Override
    public void onApplicationEvent(ProductEvent productEvent) {
        switch (productEvent.getEventType()){
            case CREATED:{
                log.info("Query model receive command event: {}", productEvent.getEventBody());

                queryDas.saveProduct(productEvent.getEventBody());
                log.info("Product Saved: {}", productEvent.getEventBody());
                break;
            }
            case DELETED:{
                log.info("Query model receive DELETE event: {}",productEvent.getProductId());
                queryDas.deleteProduct(productEvent.getProductId());
                break;
            }
        }


    }
}
