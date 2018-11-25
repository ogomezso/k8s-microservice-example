package com.datahack.k8sms.product.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.context.ApplicationEvent;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProductEvent extends ApplicationEvent {
    public enum EventType {
        CREATED ,
        DELETED
    }
    private EventType eventType;
    private Product eventBody;
    private String productId;

    public ProductEvent(Object source, Product eventBody, EventType eventType) {
        super(source);
        this.eventBody = eventBody;
        this.eventType = eventType;
        this.productId = null;
    }

    public ProductEvent(Object source, String prodId, EventType eventType) {
        super(source);
        this.eventBody = null;
        this.eventType = eventType;
        this.productId = prodId;
    }



}
