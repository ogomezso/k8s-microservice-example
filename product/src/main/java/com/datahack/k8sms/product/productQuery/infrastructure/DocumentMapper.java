package com.datahack.k8sms.product.productQuery.infrastructure;

import com.datahack.k8sms.product.domain.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DocumentMapper {

    ProductDocument domain2Document(Product product);
    Product document2Domain(ProductDocument productDocument);
}
