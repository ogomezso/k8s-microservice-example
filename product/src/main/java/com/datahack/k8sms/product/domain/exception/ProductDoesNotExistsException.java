package com.datahack.k8sms.product.domain.exception;

public class ProductDoesNotExistsException extends Exception{

    public ProductDoesNotExistsException(String message) {
        super(message);
    }
}
