package com.datahack.k8sms.product.productApi.application;

import com.datahack.k8sms.product.domain.model.Product;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Component
public class ProductValidator {


    Boolean validateProduct(Product product){

        return product.getExpirationDate().after(new Date());
    }
}
