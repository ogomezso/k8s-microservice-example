package com.datahack.promos.promosApi.infrastructure.rest.model;

import com.datahack.promos.domain.model.ProductPromo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class SellerApiRequest {

    private String sellerId;
    private String promoId;
    private List<ProductPromo> productsPromo;
    private Integer quantity;
}
