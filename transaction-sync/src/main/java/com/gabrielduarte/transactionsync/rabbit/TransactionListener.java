package com.gabrielduarte.transactionsync.rabbit;

import com.gabrielduarte.transactionsync.client.OrderClient;
import com.gabrielduarte.transactionsync.domain.Transaction;
import com.gabrielduarte.transactionsync.mapper.OrderMapper;
import com.gabrielduarte.transactionsync.request.OrderRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionListener {

    private final OrderClient orderClient;

    private final OrderMapper orderMapper;

    @RabbitListener(queues = "TRANSACTION-QUEUE")
    public void getMessageAndSendPost(Transaction transaction) {
        log.info("m:getMessageAndSendPost, consuming from rabbit");
        OrderRequest orderRequest = orderMapper.toOrderRequest(transaction);
        log.info("making request to orderApi");
        orderClient.sendTransaction(orderRequest);
        log.info("m:getMessageAndSendPost,  oderApi request done");
    }

}
