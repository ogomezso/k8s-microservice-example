package com.datahack.k8sms.orders.ordersApi.application;

import com.datahack.k8sms.orders.domain.model.OrderCommand;
import com.datahack.k8sms.orders.ordersCommand.infrastructure.CommandServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
class CommandClient {

    private final CommandServer commandServer;

    @Autowired
    public CommandClient(CommandServer commandServer) {
        this.commandServer = commandServer;
    }

    OrderCommand createCommand(OrderCommand orderCommand){
        return commandServer.createClientOrderCommand(orderCommand);
    }

    boolean deleteOrder(String id) {
        return commandServer.deleteOrder(id);
    }
}
