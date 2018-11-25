package com.datahack.k8sms.product.productCommand.infratructure;


import com.datahack.k8sms.product.domain.model.ProductEvent;
import com.datahack.k8sms.product.domain.model.Product;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
@NoArgsConstructor
@Slf4j
class CommandEventPublisher {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    void publishCreateProductEvent(final Product product) {

        ProductEvent event = new ProductEvent(this, product, ProductEvent.EventType.CREATED);
        applicationEventPublisher.publishEvent(event);
        log.info("Client Command Event Published with Body {}", product);
    }

    void publishDeleteProductEvent(final String id) {

        ProductEvent event = new ProductEvent(this, id, ProductEvent.EventType.DELETED);
        applicationEventPublisher.publishEvent(event);
        log.info("Client Command Event Published with ID {}", id);
    }
}
