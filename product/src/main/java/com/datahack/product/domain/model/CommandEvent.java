package com.datahack.product.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.context.ApplicationEvent;

@EqualsAndHashCode(callSuper = true)
@Data
public class CommandEvent extends ApplicationEvent {

    private ProductCommand eventBody;

    public CommandEvent(Object source, ProductCommand eventBody) {
        super(source);
        this.eventBody = eventBody;
    }


}
