package com.gabrielduarte.transactionsync.rabbit;

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
        return ExchangeBuilder.topicExchange("TRANSACTION-DONE").build();
    }

    @Bean
    public Queue transactionQueue() {
        return QueueBuilder.durable("TRANSACTION-QUEUE")
                            .deadLetterExchange("TRANSACTION-DONE")
                            .deadLetterRoutingKey("TO-DLQ")
                            .build();
    }

    @Bean
    public Queue dlqQueue() {
        return QueueBuilder.durable("TRANSACTION-DLQ-QUEUE").build();
    }

    @Bean
    public Binding createBindingKey(Queue transactionQueue, Exchange transactionExchange) {
        return BindingBuilder.bind(transactionQueue)
                                .to(transactionExchange)
                                .with("TO-TRANSACTION-QUEUE")
                                .noargs();
    }

    @Bean
    public Binding createDLQBindingKey(Queue dlqQueue, Exchange transactionExchange) {
        return BindingBuilder.bind(dlqQueue)
                .to(transactionExchange)
                .with("TO-DLQ")
                .noargs();
    }

    @Bean
    public MessageConverter messageConverter(ObjectMapper objectMapper) {
        return new Jackson2JsonMessageConverter(objectMapper);
    }

}
