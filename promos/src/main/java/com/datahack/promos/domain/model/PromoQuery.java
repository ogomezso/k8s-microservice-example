package com.datahack.promos.domain.model;

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
public class PromoQuery {

    private Long id;

    private String promoId;

    private List<Promo> promos;

}
