package com.gabrielduarte.transactionsync.consumer;

import com.gabrielduarte.transactionsync.client.OrderClient;
import com.gabrielduarte.transactionsync.domain.event.TransactionEvent;
import com.gabrielduarte.transactionsync.mapper.OrderMapper;
import com.gabrielduarte.transactionsync.request.OrderRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SendCreateOrderRequestConsumer {

    private final OrderClient orderClient;

    private final OrderMapper orderMapper;

    @RabbitListener(queues = "send-create-order-request-queue")
    public void consume(final TransactionEvent transactionEvent) {
        log.info("m:getMessageAndSendPost, consuming from rabbit");

        final OrderRequest orderRequest = orderMapper.toOrderRequest(transactionEvent);
        orderClient.create(orderRequest);

        log.info("m:getMessageAndSendPost,  oderApi request sent");
    }

}
