package com.datahack.k8sms.orders.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class OrderCommand {

    private String clientId;
    private String promoId;
    private Integer quantity;
}
