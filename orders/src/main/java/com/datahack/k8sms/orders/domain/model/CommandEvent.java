package com.datahack.k8sms.orders.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.context.ApplicationEvent;

@EqualsAndHashCode(callSuper = true)
@Data
public class CommandEvent extends ApplicationEvent {

    public enum EventType {
        CREATED ,
        DELETED
    }
    private EventType eventType;
    private OrderCommand eventBody;
    private String productId;

    public CommandEvent(Object source, OrderCommand eventBody, EventType eventType) {
        super(source);
        this.eventBody = eventBody;
        this.eventType = eventType;
        this.productId = null;
    }

    public CommandEvent(Object source, String prodId, EventType eventType) {
        super(source);
        this.eventBody = null;
        this.eventType = eventType;
        this.productId = prodId;
    }


}
