package com.datahack.k8sms.promos.promosApi.application;


import com.datahack.k8sms.promos.domain.model.Promo;
import com.datahack.k8sms.promos.promosCommand.CommandServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CommandClient {

    private final CommandServer commandServer;


    @Autowired
    public CommandClient(CommandServer commandServer){
        this.commandServer = commandServer;
    }

    Promo createPromo(Promo promo){
        log.info("Client calls create Promo");
        return commandServer.createPromo(promo);
    }

    boolean deletePromo(String id) {return commandServer.deletePromo(id);}

}
