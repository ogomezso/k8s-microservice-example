package com.datahack.k8sms.orders.ordersCommand.infrastructure;

import com.datahack.k8sms.orders.domain.model.OrderCommand;
import com.datahack.k8sms.orders.domain.model.CommandEvent;
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

    void publishCommandEvent(final OrderCommand orderCommand) {

        CommandEvent event = new CommandEvent(this, orderCommand);
        applicationEventPublisher.publishEvent(event);
        log.info("Client Command Event Published with Body {}", orderCommand);
    }
}
