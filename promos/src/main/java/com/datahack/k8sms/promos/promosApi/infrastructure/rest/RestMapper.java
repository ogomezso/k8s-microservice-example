package com.datahack.k8sms.promos.promosApi.infrastructure.rest;


import com.datahack.k8sms.promos.domain.model.Promo;
import com.datahack.k8sms.promos.promosApi.infrastructure.rest.model.PromoApiRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestMapper {

    //TODO: Hacerlo bien.
    Promo request2Domain(PromoApiRequest request);
}
