package com.datahack.promos.promosQuery;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface QueryRepository extends MongoRepository<PromoQueryDocument,String> {
}