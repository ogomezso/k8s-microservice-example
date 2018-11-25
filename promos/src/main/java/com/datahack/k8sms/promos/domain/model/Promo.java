package com.datahack.k8sms.promos.domain.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class Promo {
    private String id;
    private String sellerId;
    private Date timeEnd;
    private Integer quantity;
    private String description;
    private List<ProductPromo> productsPromo;

}
