package com.datahack.promos.promosApi.infrastructure.rest;


import com.datahack.promos.domain.model.Promo;
import com.datahack.promos.domain.model.PromoCommand;
import com.datahack.promos.promosApi.infrastructure.rest.model.PromoApiRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestMapper {

    //TODO: Hacerlo bien.
    Promo request2Domain(PromoApiRequest request);
}
