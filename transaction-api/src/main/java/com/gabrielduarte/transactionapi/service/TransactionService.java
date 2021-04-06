package com.gabrielduarte.transactionapi.service;

import com.gabrielduarte.transactionapi.domain.Transaction;
import com.gabrielduarte.transactionapi.kafka.TransactionProducer;
import com.gabrielduarte.transactionapi.mapper.TransactionMapper;
import com.gabrielduarte.transactionapi.repository.TransactionRepository;
import com.gabrielduarte.transactionapi.request.TransactionRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class TransactionService {

    private final TransactionRepository repository;
    private final TransactionMapper mapper;
    private final TransactionProducer producer;

    public void createTransaction(final TransactionRequest request) {
        Transaction transaction = mapper.toEntity(request);
        repository.save(transaction);

        log.info("m:createTransaction, preparando transacao para ser enviada");
        producer.sendMessageTransactionDone(transaction);
        log.info("m:createTransaction, transacao enviada p kafka");
    }

}
