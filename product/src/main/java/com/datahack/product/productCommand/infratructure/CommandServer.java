package com.datahack.product.productCommand.infratructure;

import com.datahack.product.domain.model.ProductCommand;
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
    public ProductCommand createClientOrderCommand(ProductCommand orderCommand){

        ProductCommand savedObject = commandDas.saveClientOrder(orderCommand);
        eventPublisher.publishCommandEvent(orderCommand);

        return savedObject;
    }
}
