package com.gabrielduarte.transactionapi.producer;

import com.gabrielduarte.transactionapi.domain.event.TransactionEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionDoneProducer {

    @Value("${topic.name.producer}")
    private String topicName;

    private final KafkaTemplate<String, TransactionEvent> kafkaTemplate;

    public void produce(final TransactionEvent event) {
        kafkaTemplate.send(topicName, event.toString(), event);
    }

}
