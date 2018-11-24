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
public class ProductQuery {

    private String productId;
    private String productName;
    private Date expirationDate;
    private BigDecimal productPrice;
    private Integer quantity;
}
