package com.datahack.k8sms.product.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class Product {
    private String id;
    private String productName;
    private String vendId;
    private Integer quantity;
    private Double price;
    private Date expirationDate;
}
