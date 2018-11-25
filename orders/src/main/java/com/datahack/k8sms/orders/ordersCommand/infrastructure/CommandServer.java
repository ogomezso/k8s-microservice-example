package com.datahack.k8sms.orders.ordersCommand.infrastructure;

import com.datahack.k8sms.orders.domain.model.OrderCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
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
        log.info("Saving order command {}",orderCommand);
        OrderCommand savedObject = commandDas.saveClientOrder(orderCommand);
        log.info("Saved order command {}",savedObject);
        eventPublisher.publishCreateCommandEvent(savedObject);

        return savedObject;
    }


    @Transactional
    public boolean deleteOrder(String id){
        if(commandDas.deleteOrder(id)){
            eventPublisher.publishDeleteProductEvent(id);
            return true;
        }else{
            return false;
        }
    }
}
