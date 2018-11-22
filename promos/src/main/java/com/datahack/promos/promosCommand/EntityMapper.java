package com.datahack.promos.promosCommand;


import com.datahack.promos.domain.model.Promo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface EntityMapper {

    PromoCommandEntity domain2Entity(Promo promo);

}
