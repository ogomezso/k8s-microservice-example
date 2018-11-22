package com.datahack.promos.promosCommand;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
interface CommandRepository extends JpaRepository<PromoCommandEntity, UUID> {
}
