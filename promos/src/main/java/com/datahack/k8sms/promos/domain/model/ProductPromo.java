package com.datahack.k8sms.promos.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class ProductPromo {
    private String productId;
    private Integer quantity;
    private BigDecimal unitPrice;
}

