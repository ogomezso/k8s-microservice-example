package com.datahack.promos.promosQuery;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class ProductApiResponse {
    private Integer productId;
    private String productName;
    private String vendorName;
    private Integer vendId;
    private Integer quantity;
    private Double price;
    private Date expirationDate;
}
