package com.datahack.product.productCommand.infratructure.domain.rest;

import com.datahack.product.domain.model.ProductCommand;
import com.datahack.product.productCommand.infratructure.domain.rest.model.ProductApiRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestMapper {

    ProductCommand request2Domain(ProductApiRequest request);
}
