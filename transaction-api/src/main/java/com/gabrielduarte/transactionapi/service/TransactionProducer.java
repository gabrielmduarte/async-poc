package com.gabrielduarte.transactionapi.service;

import com.gabrielduarte.transactionapi.domain.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionProducer {

    @Value("${topic.name.producer}")
    private final String topicName;

    private final KafkaTemplate<String, Transaction> kafkaTemplate;

    public void sendMessageTransactionDone(final Transaction transaction) {
        kafkaTemplate.send(topicName, transaction);
    }

}
