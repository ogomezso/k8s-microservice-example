package com.datahack.promos.domain.model;

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
    private String description;
    private Date timeEnd;
    private Integer quantity;
    private BigDecimal unitPrice;
}

