package com.datahack.k8sms.promos.domain.exception;

public class PromoDoesNotExistsException extends Exception{

    public PromoDoesNotExistsException(String message) {
        super(message);
    }
}
