package com.datahack.k8sms.product.productApi.application;

import com.datahack.k8sms.product.domain.exception.ProductDoesNotExistsException;
import com.datahack.k8sms.product.domain.exception.ProductInvalidException;
import com.datahack.k8sms.product.domain.model.Product;
import com.datahack.k8sms.product.productQuery.infrastructure.QueryDas;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class ProductProcessor {

    private final ProductValidator productValidator;
    private final CommandClient commandClient;
    private final QueryClient queryClient;

    @Autowired
    public ProductProcessor(ProductValidator productValidator
            , CommandClient commandClient
            , QueryClient queryClient) {
        this.productValidator = productValidator;
        this.commandClient = commandClient;
        this.queryClient = queryClient;
    }
    public Product createProduct (Product product) throws ProductInvalidException {

        log.info("Creating Product: {}",product);
        Optional<Boolean> validated = Optional.ofNullable(productValidator.validateProduct(product));

        return validated.filter(v -> v.equals(true))
                .map(response ->  commandClient.createProduct(product))
                .orElseThrow(() -> new ProductInvalidException("Product is invalid."));
    }

    public Product modifyProduct(Product product) throws ProductDoesNotExistsException, ProductInvalidException {
        log.info("Modifying Product: {}",product);
        Product productSaved = getProduct(product.getId());

        if(! productSaved.getVendId().equals(product.getVendId())){
            throw new ProductInvalidException("Seller cannot be modified");
        }
        Optional<Boolean> validated = Optional.ofNullable(productValidator.validateProduct(product));
        return validated.filter(v -> v.equals(true))
                .map(response ->  queryClient.modifyProduct(product))
                .orElseThrow(() -> new ProductInvalidException("Product is invalid."));
    }

    public Product getProduct(String id) throws ProductDoesNotExistsException {
        log.info("Getting Product: {}",id);
        return queryClient.getProduct(id);
    }

    public boolean deleteProduct(String id)  {
        log.info("Deleting Product: {}",id);
        return commandClient.deleteProduct(id);
    }

}
