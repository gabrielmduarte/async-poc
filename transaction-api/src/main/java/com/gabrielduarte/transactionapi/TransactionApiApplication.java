package com.gabrielduarte.transactionapi;

import com.gabrielduarte.transactionapi.channel.TransactionDoneChannel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@EnableBinding(TransactionDoneChannel.class)
@SpringBootApplication
public class TransactionApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionApiApplication.class, args);
    }

}
