package com.gabrielduarte.transactionapi.service;

import com.gabrielduarte.transactionapi.domain.Transaction;
import com.gabrielduarte.transactionapi.mapper.TransactionMapper;
import com.gabrielduarte.transactionapi.repository.TransactionRepository;
import com.gabrielduarte.transactionapi.request.TransactionRequest;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private final TransactionRepository repository;
    private final TransactionMapper mapper;

    public TransactionService(final TransactionRepository repository, final TransactionMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public void createTransaction(final TransactionRequest transaction) {
        Transaction entity = mapper.toEntity(transaction);

        repository.save(entity);
    }
}
