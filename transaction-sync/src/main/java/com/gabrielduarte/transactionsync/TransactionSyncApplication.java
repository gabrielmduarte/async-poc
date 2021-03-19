package com.gabrielduarte.transactionsync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@EnableFeignClients
@SpringBootApplication
public class TransactionSyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionSyncApplication.class, args);
    }

}
