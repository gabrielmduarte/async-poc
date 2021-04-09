package com.gabrielduarte.transactionapi.service;

import com.gabrielduarte.transactionapi.domain.request.TransactionRequest;
import com.gabrielduarte.transactionapi.mapper.TransactionMapper;
import com.gabrielduarte.transactionapi.producer.TransactionDoneProducer;
import com.gabrielduarte.transactionapi.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class TransactionService {

    private final TransactionRepository repository;
    private final TransactionMapper mapper;
    private final TransactionDoneProducer producer;

    public void createTransaction(final TransactionRequest request) {
        repository.save(mapper.toEntity(request));

        log.info("m:createTransaction, preparando transacao para ser enviada");
        producer.produce(mapper.toEvent(request));
        log.info("m:createTransaction, transacao enviada p kafka");
    }

}
