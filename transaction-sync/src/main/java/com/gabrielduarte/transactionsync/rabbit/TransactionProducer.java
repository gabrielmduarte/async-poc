package com.gabrielduarte.transactionsync.rabbit;

import com.gabrielduarte.transactionsync.domain.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TransactionProducer {

    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(final Transaction transaction) {
        rabbitTemplate.convertAndSend("TRANSACTION-DONE", "TO-FIRST-QUEUE", transaction);
    }



}
