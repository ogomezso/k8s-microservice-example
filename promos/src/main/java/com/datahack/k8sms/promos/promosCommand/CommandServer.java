package com.datahack.k8sms.promos.promosCommand;

import com.datahack.k8sms.promos.domain.model.Promo;
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
    public CommandServer(CommandDas commandDas
            , CommandEventPublisher eventPublisher) {
        this.commandDas = commandDas;
        this.eventPublisher = eventPublisher;
    }

    @Transactional
    public Promo createPromo(Promo promo){
        log.info("Creating promo in server");
        Promo savedObject = commandDas.savePromo(promo);
        log.info("Publishing event with savedObject: {}",savedObject);
        eventPublisher.publishPromoEvent(savedObject);
        return savedObject;
    }

    @Transactional
    public boolean deletePromo(String id){
        if(commandDas.deletePromo(id)){
            eventPublisher.publishDeletedPromoEvent(id);
            return true;
        }else{
            return false;
        }

    }
}
