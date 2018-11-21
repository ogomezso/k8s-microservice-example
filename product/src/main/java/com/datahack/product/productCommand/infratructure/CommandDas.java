package com.datahack.product.productCommand.infratructure;


import com.datahack.product.domain.model.ProductCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
class CommandDas {

    private final CommandRepository commandRepository;
    private final EntityMapper mapper;

    @Autowired
    public CommandDas(CommandRepository commandRepository, EntityMapper mapper) {
        this.commandRepository = commandRepository;
        this.mapper = mapper;
    }

    ProductCommand saveClientOrder(ProductCommand orderCommand) {

        ProductCommandEntity entity2Save = mapper.domain2Entity(orderCommand);

        return mapper.entity2Domain(commandRepository.save(entity2Save));
    }
}
