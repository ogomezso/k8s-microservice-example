package com.datahack.k8sms.orders.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.context.ApplicationEvent;

@EqualsAndHashCode(callSuper = true)
@Data
public class CommandEvent extends ApplicationEvent {

    private OrderCommand eventBody;

    public CommandEvent(Object source, OrderCommand eventBody) {
        super(source);
        this.eventBody = eventBody;
    }


}
