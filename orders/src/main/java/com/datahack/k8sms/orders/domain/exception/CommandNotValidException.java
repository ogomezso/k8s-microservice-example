package com.datahack.k8sms.orders.domain.exception;

public class CommandNotValidException extends Exception{

    public CommandNotValidException(String message) {
        super(message);
    }
}
