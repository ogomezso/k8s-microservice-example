package com.datahack.k8sms.product.productApi.infrastructure.rest;

import com.datahack.k8sms.product.domain.model.Product;
import com.datahack.k8sms.product.productApi.infrastructure.rest.model.ProductApiRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestMapper {

    Product request2Domain(ProductApiRequest request);
}
