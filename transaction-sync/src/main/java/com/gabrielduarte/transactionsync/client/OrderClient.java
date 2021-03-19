package com.gabrielduarte.transactionsync.client;

import com.gabrielduarte.transactionsync.domain.Transaction;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(url = "localhost:7070/order", name = "orderClient")
public interface OrderClient {

    @PostMapping
    void sendTransaction(final Transaction transaction);

}
