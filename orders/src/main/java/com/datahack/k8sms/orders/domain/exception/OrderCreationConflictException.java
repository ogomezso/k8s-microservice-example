package com.datahack.k8sms.orders.domain.exception;

public class OrderCreationConflictException extends Exception {

    public OrderCreationConflictException(String message) {
        super(message);
    }
}
