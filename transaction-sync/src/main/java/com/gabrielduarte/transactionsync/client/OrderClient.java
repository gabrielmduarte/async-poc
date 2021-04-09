package com.gabrielduarte.transactionsync.client;

import com.gabrielduarte.transactionsync.request.OrderRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(url = "localhost:7070", name = "orderClient")
public interface OrderClient {

    @PostMapping("/orders")
    void create(final OrderRequest orderRequest);

}
