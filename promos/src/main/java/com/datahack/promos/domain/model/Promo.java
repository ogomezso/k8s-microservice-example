package com.datahack.promos.domain.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class Promo {
    private String id;
    private String sellerId;
    private List<ProductPromo> productsPromo;
}
