package com.datahack.k8sms.product.productCommand.infratructure;


import com.datahack.k8sms.product.domain.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
class CommandDas {

    private final CommandRepository commandRepository;
    private final ProductCommandBuilder productCommandBuilder;

    @Autowired
    public CommandDas(CommandRepository commandRepository
            , ProductCommandBuilder productCommandBuilder) {
        this.commandRepository = commandRepository;
        this.productCommandBuilder = productCommandBuilder;
    }

    Product saveProduct(Product product) {

        ProductCommandEntity entity2Save = productCommandBuilder.buildCommandEntity(product);

        return productCommandBuilder.buildProduct(commandRepository.save(entity2Save),product);
    }

    boolean deleteProduct(String id) {
        boolean exists = commandRepository.existsById(UUID.fromString(id));
        commandRepository.deleteById(UUID.fromString(id));
        return exists;
    }
}
