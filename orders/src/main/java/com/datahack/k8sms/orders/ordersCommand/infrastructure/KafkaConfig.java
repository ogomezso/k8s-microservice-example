package com.datahack.k8sms.orders.ordersCommand.infrastructure;

import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(CommandStream.class)
class KafkaConfig {
}
