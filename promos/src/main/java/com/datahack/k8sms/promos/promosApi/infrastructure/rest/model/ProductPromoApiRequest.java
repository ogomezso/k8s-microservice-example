package com.datahack.k8sms.promos.promosApi.infrastructure.rest.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class ProductPromoApiRequest {
    private String productId;
    private Integer quantity;
    private BigDecimal unitPrice;
}
