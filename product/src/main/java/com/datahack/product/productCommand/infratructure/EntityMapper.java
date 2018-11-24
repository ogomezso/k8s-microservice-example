package com.datahack.product.productCommand.infratructure;

import com.datahack.product.domain.model.ProductCommand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface EntityMapper {

    ProductCommandEntity domain2Entity(ProductCommand productCommand);
    ProductCommand entity2Domain(ProductCommandEntity entity);
}
