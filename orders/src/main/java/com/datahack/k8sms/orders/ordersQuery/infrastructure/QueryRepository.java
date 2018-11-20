package com.datahack.k8sms.orders.ordersQuery.infrastructure;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueryRepository extends MongoRepository<OrderQueryDocument,Long> {
}
