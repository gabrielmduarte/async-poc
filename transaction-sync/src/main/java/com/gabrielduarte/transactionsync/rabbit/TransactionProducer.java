package com.gabrielduarte.transactionsync.rabbit;

import com.gabrielduarte.transactionsync.domain.Transaction;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class TransactionProducer {

    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(final Transaction transaction) {
        log.info("m:sendMessage, i:producing message in rabbit");
        rabbitTemplate.convertAndSend("TRANSACTION-DONE", "TO-TRANSACTION-QUEUE", transaction);
        log.info("m:sendMessage, i: message sent rabbit");
    }

}
