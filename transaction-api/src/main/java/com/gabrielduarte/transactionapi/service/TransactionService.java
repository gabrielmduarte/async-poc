package com.gabrielduarte.transactionapi.service;

import com.gabrielduarte.transactionapi.domain.Transaction;
import com.gabrielduarte.transactionapi.mapper.TransactionMapper;
import com.gabrielduarte.transactionapi.repository.TransactionRepository;
import com.gabrielduarte.transactionapi.request.TransactionRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransactionService {

    private final TransactionRepository repository;
    private final TransactionMapper mapper;
    private final TransactionProducer producer;

    public void createTransaction(final TransactionRequest request) {
        Transaction transaction = mapper.toEntity(request);
        repository.save(transaction);

        producer.sendMessageTransactionDone(transaction);
    }

}
