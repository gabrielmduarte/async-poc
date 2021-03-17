package com.gabrielduarte.transactionsync.rabbit;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.*;
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
                            .deadLetterRoutingKey("DLQ-ROUTING")
                            .build();
    }

    @Bean
    public Queue DlqQueue() {
        return QueueBuilder.durable("TRANSACTION-DQL").build();
    }

    @Bean
    public Binding createBindingKey(Queue transactionQueue, Exchange transactionExchange) {
        return BindingBuilder.bind(transactionQueue)
                                .to(transactionExchange)
                                .with("TO-FIRST-QUEUE")
                                .noargs();
    }

    @Bean
    public Binding createDLQBindingKey(Queue transactionQueue, Exchange transactionExchange) {
        return BindingBuilder.bind(transactionQueue)
                .to(transactionExchange)
                .with("DLQ-ROUTING")
                .noargs();
    }

    @Bean
    public MessageConverter messageConverter(ObjectMapper objectMapper) {
        return new Jackson2JsonMessageConverter(objectMapper);
    }

}
