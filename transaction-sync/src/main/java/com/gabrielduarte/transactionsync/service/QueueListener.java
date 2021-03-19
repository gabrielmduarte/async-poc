package com.gabrielduarte.transactionsync.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QueueListener implements MessageListener {

    private final MessageConverter messageConverter;


    @Override
    public void onMessage(Message message) {
        // ?????????
    }
}
