package com.datahack.k8sms.orders.ordersApi.application;

import com.datahack.k8sms.orders.domain.exception.PromoNotAvailableException;
import com.datahack.k8sms.orders.domain.exception.OrderDoesNotExistsException;
import com.datahack.k8sms.orders.domain.model.OrderCommand;
import com.datahack.k8sms.orders.domain.model.OrderQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClientOrderProcessor {

    private final OrderValidator orderValidator;
    private final CommandClient commandClient;
    private final QueryClient queryClient;

    @Autowired
    public ClientOrderProcessor(OrderValidator orderValidator
            , CommandClient commandClient
            , QueryClient queryClient) {
        this.orderValidator = orderValidator;
        this.commandClient = commandClient;
        this.queryClient = queryClient;
    }

    public OrderCommand processClientOrder(OrderCommand client) throws PromoNotAvailableException {

        Optional<Boolean> validated = Optional.ofNullable(orderValidator.validatePromo(client));

        return validated.filter(v -> v.equals(true))
                .map(response ->  commandClient.createCommand(client))
                .orElseThrow(() -> new PromoNotAvailableException("Promo not Available"));
    }

    public OrderQuery getOrder(String orderid) throws OrderDoesNotExistsException {
        return queryClient.getOrder(orderid);
    }

    public boolean deleteOrder(String orderid) {
        return commandClient.deleteOrder(orderid);
    }
}
