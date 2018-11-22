package com.datahack.promos.promosApi.application;


import com.datahack.promos.domain.model.Promo;
import com.datahack.promos.promosCommand.CommandServer;
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
        return commandServer.createPromo(promo);
    }

}
