package com.datahack.product.productCommand.infratructure.domain.rest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class ProductApiRequest {
    private String productName;
    private String vendorName;
    private Integer productId;
    private Integer vendId;
    private Integer quantity;
    private Double price;
    private Date expirationDate;
}
