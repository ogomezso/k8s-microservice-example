package com.datahack.product.productQuery.infrastructure;

import com.datahack.product.domain.model.ProductQuery;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DocumentMapper {

    ProductDocument doamin2Document(ProductQuery productQuery);
    ProductQuery document2Doamin(ProductDocument productDocument);
}
