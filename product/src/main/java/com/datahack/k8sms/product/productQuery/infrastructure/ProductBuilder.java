package com.datahack.k8sms.product.productQuery.infrastructure;

import com.datahack.k8sms.product.domain.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@Component
@Slf4j
public class ProductBuilder {
    private final PodamFactory podamFactory = new PodamFactoryImpl();
    private final DocumentMapper mapper;

    @Autowired
    ProductBuilder(DocumentMapper mapper){
        this.mapper = mapper;
    }

    Product buildProduct(ProductDocument productDocument){
        log.info("Building product from document");
        Product prod = mapper.document2Domain(productDocument);
        prod.setId(productDocument.getId());
        return prod;
    }

    ProductDocument buildDocument(Product product){
        ProductDocument doc = mapper.domain2Document(product);
        doc.setId(product.getId());
        return doc;
    }
}
