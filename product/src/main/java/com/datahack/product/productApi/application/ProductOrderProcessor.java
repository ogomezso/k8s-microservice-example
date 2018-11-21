package com.datahack.product.productApi.application;

import com.datahack.product.domain.model.ProductCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductOrderProcessor {

    private final CommandClient commandClient;

    @Autowired
    public ProductOrderProcessor(CommandClient commandClient) {
        this.commandClient = commandClient;
    }

    public ProductCommand processClientOrder(ProductCommand product) {
        return commandClient.createCommand(product);
    }

}
