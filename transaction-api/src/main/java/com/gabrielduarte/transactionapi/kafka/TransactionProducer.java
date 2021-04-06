package com.gabrielduarte.transactionapi.kafka;

import com.gabrielduarte.transactionapi.domain.Transaction;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionProducer {

    @Value("${topic.name.producer}")
    private String topicName;

    private final KafkaTemplate<String, Transaction> kafkaTemplate;

    public void sendMessageTransactionDone(final Transaction transaction) {
        kafkaTemplate.send(topicName, transaction);
        log.info("m:sendMessageTransactionDone, transaction id:{}", transaction.getId().toString());
    }

}
