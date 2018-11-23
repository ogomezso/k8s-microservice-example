package com.datahack.promos.promosQuery;

import com.datahack.promos.domain.model.PromoQuery;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DocumentMapper {

    PromoQueryDocument domain2Document(PromoQuery promoQuery);
    PromoQuery document2Domain(PromoQueryDocument promoQueryDocument);
}
