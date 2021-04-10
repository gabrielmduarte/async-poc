package com.gabrielduarte.transactionapi.repository;

import com.gabrielduarte.transactionapi.domain.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
}
