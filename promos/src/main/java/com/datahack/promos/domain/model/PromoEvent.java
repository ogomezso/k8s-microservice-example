package com.datahack.promos.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.context.ApplicationEvent;

import java.util.Optional;

@EqualsAndHashCode(callSuper = true)
@Data
public class PromoEvent extends ApplicationEvent {

    public enum EventType {
        CREATED ,
        DELETED
    }
    private EventType eventType;
    private Promo eventBody;
    private String promoId;

    public PromoEvent(Object source, Promo eventBody, EventType eventType) {
        super(source);
        this.eventBody = eventBody;
        this.eventType = eventType;
        this.promoId = null;
    }

    public PromoEvent(Object source, String promoId, EventType eventType) {
        super(source);
        this.eventBody = null;
        this.eventType = eventType;
        this.promoId = promoId;
    }
}
