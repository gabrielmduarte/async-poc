package com.gabrielduarte.transactionsync.producer;

import com.gabrielduarte.transactionsync.domain.event.TransactionEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class SendCreateOrderRequestProducer {

    private final RabbitTemplate rabbitTemplate;

    public void produce(final TransactionEvent transactionEvent) {
        log.info("m:sendMessage, i:producing message in rabbit");
        rabbitTemplate.convertAndSend("send-create-order-request-exchange", "send-create-order-request-queue", transactionEvent);
        log.info("m:sendMessage, i: message sent rabbit");
    }

}
