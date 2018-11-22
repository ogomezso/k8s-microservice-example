package com.datahack.promos.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.context.ApplicationEvent;

@EqualsAndHashCode(callSuper = true)
@Data
public class PromoEvent extends ApplicationEvent {

    private Promo eventBody;

    public PromoEvent(Object source, Promo eventBody) {
        super(source);
        this.eventBody = eventBody;
    }
}
