package com.datahack.k8sms.orders.ordersCommand.infrastructure;

import com.datahack.k8sms.orders.domain.exception.CommandNotValidException;
import com.datahack.k8sms.orders.domain.model.CommandEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;

@Component
@Slf4j
class KafkaEventListener implements ApplicationListener<CommandEvent> {

    private final CommandStream commandStream;

    @Autowired
    public KafkaEventListener(CommandStream commandStream) {
        this.commandStream = commandStream;
    }

    @Override
    public void onApplicationEvent(CommandEvent commandEvent) {
        try {
            Message message = getMessage(commandEvent);
            MessageChannel messageChannel = commandStream.command();
            messageChannel.send(message);
        } catch (CommandNotValidException e) {
            log.error("Error Publishing order message on command application. Message: {}", commandEvent.getEventBody());
        }
    }

    private Message getMessage(CommandEvent commandEvent) throws CommandNotValidException {
        String payload = JsonMessageBuilder.toJson(commandEvent).orElseThrow(() -> new CommandNotValidException("Not Valid message"));
        return MessageBuilder
                .withPayload(payload)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build();
    }
}
