package com.datahack.k8sms.orders.ordersCommand.infrastructure;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
interface CommandStream {

    String OUTPUT = "orders";

    @Output(OUTPUT)
    SubscribableChannel command();
}
