package com.datahack.k8sms.orders.ordersCommand.infrastructure;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
class JsonMessageBuilder {

    public static Optional<String> toJson(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.setSerializationInclusion(Include.NON_NULL);

        Optional<String> json = Optional.empty();

        try {
            json = Optional.of(mapper.writeValueAsString(obj));

        } catch (JsonProcessingException e) {
            log.error("Json serialization issues with message object");
        }

        return json;
    }

}
