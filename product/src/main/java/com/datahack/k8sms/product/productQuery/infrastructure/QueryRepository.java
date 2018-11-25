package com.datahack.k8sms.product.productQuery.infrastructure;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueryRepository extends MongoRepository<ProductDocument, String> {
}
