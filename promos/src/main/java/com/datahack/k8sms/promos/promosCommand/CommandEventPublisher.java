package com.datahack.k8sms.promos.promosCommand;

import com.datahack.k8sms.promos.domain.model.Promo;
import com.datahack.k8sms.promos.domain.model.PromoEvent;
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

    void publishPromoEvent(final Promo promo) {
        log.info("Client Command Event Published with Body {}", promo);
        PromoEvent event = new PromoEvent(this, promo, PromoEvent.EventType.CREATED);
        applicationEventPublisher.publishEvent(event);
        log.info("Finished Publishing event with Body {}", promo);
    }

    void publishDeletedPromoEvent(String id) {
        PromoEvent event = new PromoEvent(this, id, PromoEvent.EventType.DELETED);
        applicationEventPublisher.publishEvent(event);
        log.info("Client Command Event Published with id {}", id);
    }
}