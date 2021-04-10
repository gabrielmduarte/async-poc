package com.gabrielduarte.transactionsync.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RabbitConfig {

    @Bean
    public Exchange transactionExchange() {
        return ExchangeBuilder.topicExchange("send-create-order-request-exchange").build();
    }

    @Bean
    public Queue transactionQueue() {
        return QueueBuilder.durable("send-create-order-request-queue")
                            .deadLetterExchange("send-create-order-request-exchange")
                            .deadLetterRoutingKey("send-create-order-request-queue.dlq")
                            .build();
    }

    @Bean
    public Queue dlqQueue() {
        return QueueBuilder.durable("send-create-order-request-queue.dlq").build();
    }

    @Bean
    public Binding createBindingKey(Queue transactionQueue, Exchange transactionExchange) {
        return BindingBuilder.bind(transactionQueue)
                                .to(transactionExchange)
                                .with("send-create-order-request-queue")
                                .noargs();
    }

    @Bean
    public Binding createDLQBindingKey(Queue dlqQueue, Exchange transactionExchange) {
        return BindingBuilder.bind(dlqQueue)
                .to(transactionExchange)
                .with("send-create-order-request-queue.dlq")
                .noargs();
    }

    @Bean
    public MessageConverter messageConverter(ObjectMapper objectMapper) {
        return new Jackson2JsonMessageConverter(objectMapper);
    }

}
