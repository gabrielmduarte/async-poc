package com.gabrielduarte.transactionapi.repository;

import com.gabrielduarte.transactionapi.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
