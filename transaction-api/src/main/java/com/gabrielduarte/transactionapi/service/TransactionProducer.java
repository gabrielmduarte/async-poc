package com.gabrielduarte.transactionapi.service;

import com.gabrielduarte.transactionapi.domain.Transaction;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionProducer {

    @Value("${topic.name.producer}")
    private String topicName;

    private final KafkaTemplate<String, Transaction> kafkaTemplate;

    public void sendMessageTransactionDone(final Transaction transaction) {
        ListenableFuture<SendResult<String, Transaction>> message = kafkaTemplate.send(topicName, transaction);
        log.info("teste");
    }

}
