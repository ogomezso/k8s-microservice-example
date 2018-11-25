package com.datahack.k8sms.orders.domain.exception;


public class OrderDoesNotExistsException extends Exception{

    public OrderDoesNotExistsException(String message) {
        super(message);
    }
}