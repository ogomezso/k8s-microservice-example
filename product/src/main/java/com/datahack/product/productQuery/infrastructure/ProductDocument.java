package com.datahack.product.productQuery.infrastructure;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.util.Date;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class ProductDocument {

    @Id
    private Integer productId;
    private String productName;
    private String vendorName;
    private Integer vendId;
    private Integer quantity;
    private Double price;
    private Date expirationDate;
}
