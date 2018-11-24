package com.datahack.k8sms.promos.promosCommand;


import com.datahack.k8sms.promos.domain.model.Promo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface EntityMapper {

    PromoCommandEntity domain2Entity(Promo promo);

}
