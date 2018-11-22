package com.datahack.promos.promosCommand;

import com.datahack.promos.domain.model.Promo;
import com.datahack.promos.domain.model.PromoEvent;
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

        PromoEvent event = new PromoEvent(this, promo);
        applicationEventPublisher.publishEvent(event);
        log.info("Client Command Event Published with Body {}", promo);
    }
}