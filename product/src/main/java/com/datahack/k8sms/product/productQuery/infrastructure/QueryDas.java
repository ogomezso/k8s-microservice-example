package com.datahack.k8sms.product.productQuery.infrastructure;

import com.datahack.k8sms.product.domain.exception.ProductDoesNotExistsException;
import com.datahack.k8sms.product.domain.model.Product;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class QueryDas {
    private final QueryRepository queryRepository;
    private final DocumentMapper mapper;


    @Autowired
    QueryDas(QueryRepository queryRepository, DocumentMapper mapper
            ) {
        this.queryRepository = queryRepository;
        this.mapper = mapper;
    }

    public Product saveProduct(Product product){
        log.info("Saving: {}",product);
        ProductDocument document2Save = mapper.domain2Document(product);
        log.info("Saving document: {}",document2Save);
        ProductDocument docSaved = queryRepository.save(document2Save);
        return mapper.document2Domain(docSaved);
    }

    public Product getProduct(String id) throws ProductDoesNotExistsException {
        Optional<ProductDocument> dbObj = queryRepository.findById(id);
        return dbObj.map(mapper::document2Domain)
                .orElseThrow(() -> new ProductDoesNotExistsException("Product not exists"));
    }

    public Product modifyProduct(Product product){
        ProductDocument document2Save = mapper.domain2Document(product);
        ProductDocument docSaved = queryRepository.save(document2Save);
        return mapper.document2Domain(docSaved);
    }

    public void deleteProduct(String id) {
        queryRepository.deleteById(id);
        return;
    }
}
