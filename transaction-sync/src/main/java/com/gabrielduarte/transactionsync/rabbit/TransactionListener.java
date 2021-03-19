package com.gabrielduarte.transactionsync.rabbit;

import com.gabrielduarte.transactionsync.client.OrderClient;
import com.gabrielduarte.transactionsync.domain.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionListener {

    private final OrderClient orderClient;

    @RabbitListener(queues = "FIRST-QUEUE")
    public void getMessageAndSendPost(Transaction transaction) {
        orderClient.sendTransaction(transaction);
    }

}
