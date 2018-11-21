package com.datahack.product.productApi.application;

import com.datahack.product.domain.model.ProductCommand;
import com.datahack.product.productCommand.infratructure.CommandServer;
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

    ProductCommand createCommand(ProductCommand orderCommand){
        return commandServer.createClientOrderCommand(orderCommand);
    }
}
