package com.datahack.k8sms.orders.ordersApi.infrastructure.rest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class ClientApiRequest {

    private String clientId;
    private String promoId;
    private Integer quantity;
}
