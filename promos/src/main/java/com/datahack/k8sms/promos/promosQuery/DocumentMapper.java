package com.datahack.k8sms.promos.promosQuery;

import com.datahack.k8sms.promos.domain.model.PromoQuery;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DocumentMapper {

    PromoQueryDocument domain2Document(PromoQuery promoQuery);
    PromoQuery document2Domain(PromoQueryDocument promoQueryDocument);
}
