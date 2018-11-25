package com.datahack.k8sms.product.productCommand.infratructure;

import com.datahack.k8sms.product.domain.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CommandServer {

    private final CommandDas commandDas;
    private final CommandEventPublisher eventPublisher;


    @Autowired
    public CommandServer(CommandDas commandDas
            , CommandEventPublisher eventPublisher
            ) {
        this.commandDas = commandDas;
        this.eventPublisher = eventPublisher;

    }

    @Transactional
    public Product createProduct(Product product){

        Product savedProduct = commandDas.saveProduct(product);
        eventPublisher.publishCreateProductEvent(savedProduct);
        return savedProduct;
    }

    @Transactional
    public boolean deleteProduct(String id){
        if(commandDas.deleteProduct(id)){
            eventPublisher.publishDeleteProductEvent(id);
            return true;
        }else{
            return false;
        }
    }
}
