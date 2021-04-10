package com.gabrielduarte.transactionsync.transporter;

import com.gabrielduarte.transactionsync.domain.event.TransactionEvent;
import com.gabrielduarte.transactionsync.producer.SendCreateOrderRequestProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionDoneTransporter {

    private final SendCreateOrderRequestProducer producer;

    @Value("${topic.name.consumer}")
    private String topicName;

    @KafkaListener(topics = "${topic.name.consumer}", groupId = "transaction-transporter")
    public void consume(final TransactionEvent transactionEvent) {
        producer.produce(transactionEvent);
    }

}
