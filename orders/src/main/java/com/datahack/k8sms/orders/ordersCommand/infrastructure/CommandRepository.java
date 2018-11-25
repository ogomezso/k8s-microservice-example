package com.datahack.k8sms.orders.ordersCommand.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
interface CommandRepository extends JpaRepository<OrderCommandEntity, UUID> {
}
