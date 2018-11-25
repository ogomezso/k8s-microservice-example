package com.datahack.k8sms.product.productApi.infrastructure.rest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class ProductApiRequest {
    private String id;
    @NonNull
    private String productName;
    @NonNull
    private String vendId;
    @NonNull
    private Integer quantity;
    @NonNull
    private Double price;
    @NonNull
    private Date expirationDate;
}
