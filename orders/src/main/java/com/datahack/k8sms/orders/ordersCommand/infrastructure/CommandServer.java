package com.datahack.k8sms.orders.ordersCommand.infrastructure;

import com.datahack.k8sms.orders.domain.model.OrderCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CommandServer {

    private final CommandDas commandDas;
    private final CommandEventPublisher eventPublisher;

    @Autowired
    public CommandServer(CommandDas commandDas, CommandEventPublisher eventPublisher) {
        this.commandDas = commandDas;
        this.eventPublisher = eventPublisher;
    }

    @Transactional
    public OrderCommand createClientOrderCommand(OrderCommand orderCommand){

        OrderCommand savedObject = commandDas.saveClientOrder(orderCommand);
        eventPublisher.publishCommandEvent(orderCommand);

        return savedObject;
    }
}
