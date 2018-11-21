package com.datahack.product.productCommand.infratructure;


import com.datahack.product.domain.model.CommandEvent;
import com.datahack.product.domain.model.ProductCommand;
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

    void publishCommandEvent(final ProductCommand productCommand) {

        CommandEvent event = new CommandEvent(this, productCommand);
        applicationEventPublisher.publishEvent(event);
        log.info("Client Command Event Published with Body {}", productCommand);
    }
}
