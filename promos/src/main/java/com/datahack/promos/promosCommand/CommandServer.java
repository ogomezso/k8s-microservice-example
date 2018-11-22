package com.datahack.promos.promosCommand;

import com.datahack.promos.domain.model.Promo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CommandServer {
    private final CommandDas commandDas;
   // private final CommandEventPublisher eventPublisher;

    @Autowired
    public CommandServer(CommandDas commandDas
           // , CommandEventPublisher eventPublisher) {
    ){
        this.commandDas = commandDas;
       // this.eventPublisher = eventPublisher;
    }

    @Transactional
    public Promo createPromo(Promo promo){

        Promo savedObject = commandDas.savePromo(promo);
       // eventPublisher.publishCommandEvent(savedObject);

        return savedObject;
    }
}
