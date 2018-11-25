package com.datahack.k8sms.promos.promosQuery;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface QueryRepository extends MongoRepository<PromoQueryDocument,String> {
}