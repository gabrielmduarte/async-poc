package com.gabrielduarte.transactionsync.kafka;

import com.gabrielduarte.transactionsync.domain.Transaction;
import com.gabrielduarte.transactionsync.rabbit.TransactionProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionTransporter {

    private final TransactionProducer producer;

    @Value("${topic.name.consumer}")
    private String topicName;

    @KafkaListener(topics = "${topic.name.consumer}", groupId = "transaction-transporter")
    public void consume(final Transaction transaction) {
        log.info("m:consume, info: transporting message from kafka to rabbit, transactionId:{}", transaction.getId());
        producer.sendMessage(transaction);
        log.info("m:consume, info: message sent to rabbit, transactionId:{}", transaction.getId());
    }

}
