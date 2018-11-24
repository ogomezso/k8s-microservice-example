package com.datahack.promos.promosCommand;


import com.datahack.promos.domain.model.Promo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class CommandDas {

    private final CommandRepository commandRepository;
    private final EntityMapper mapper;
    private final PromoBuilder builder;

    @Autowired
    public CommandDas(CommandRepository commandRepository
            , EntityMapper mapper
            , PromoBuilder builder) {
        this.commandRepository = commandRepository;
        this.mapper = mapper;
        this.builder = builder;
    }

    Promo savePromo(Promo promo) {
        log.info("Saving promo");
        PromoCommandEntity entity2Save = mapper.domain2Entity(promo);
        log.info("Object created to save is: {}",entity2Save);
        return builder.buildPromo(commandRepository.save(entity2Save),promo);
    }

    boolean deletePromo(String id){
        boolean exists = commandRepository.existsById(UUID.fromString(id));
        commandRepository.deleteById(UUID.fromString(id));
        return exists;
    }

}
