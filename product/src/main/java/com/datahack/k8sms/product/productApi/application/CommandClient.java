package com.datahack.k8sms.product.productApi.application;

import com.datahack.k8sms.product.productCommand.infratructure.CommandServer;
import com.datahack.k8sms.product.domain.model.Product;
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

    Product createProduct(Product product){
        return commandServer.createProduct(product);
    }

    boolean deleteProduct(String id){
        return commandServer.deleteProduct(id);
    }
}
