package com.datahack.k8sms.orders.ordersCommand.infrastructure;


import com.datahack.k8sms.orders.domain.model.OrderCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
class CommandDas {

    private final CommandRepository commandRepository;
    private final EntityMapper mapper;

    @Autowired
    public CommandDas(CommandRepository commandRepository, EntityMapper mapper) {
        this.commandRepository = commandRepository;
        this.mapper = mapper;
    }

    OrderCommand saveClientOrder(OrderCommand orderCommand) {

        OrderCommandEntity entity2Save = mapper.domain2Entity(orderCommand);
        OrderCommandEntity saved = commandRepository.save(entity2Save);
        OrderCommand returned = mapper.entity2Domain(saved);
        returned.setId(saved.getOrderId().toString());
        return returned;
    }

    boolean deleteOrder(String id) {
        boolean exists = commandRepository.existsById(UUID.fromString(id));
        commandRepository.deleteById(UUID.fromString(id));
        return exists;
    }
}
