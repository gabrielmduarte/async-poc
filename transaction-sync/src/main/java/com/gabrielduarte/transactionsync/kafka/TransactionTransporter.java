package com.gabrielduarte.transactionsync.kafka;

import com.gabrielduarte.transactionsync.domain.Transaction;
import com.gabrielduarte.transactionsync.rabbit.TransactionProducer;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionTransporter {

    private final TransactionProducer producer;

    @Value("${topic.name.consumer}")
    private String topicName;

    @KafkaListener(topics = "${topic.name.consumer}", groupId = "transaction-transporter")
    public void consume(final Transaction transaction) {
        producer.sendMessage(transaction);
    }

}
