package com.gabrielduarte.controller;

import com.gabrielduarte.request.OrderRequest;
import com.gabrielduarte.request.ProductRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/orders")
public class OrderController {

    @PostMapping
    public void createOrder(@RequestBody final OrderRequest request) {
        log.info("request received");
        log.info("swapi id = {}", request.getSwapiUserId());
        log.info("Status = {}", request.getStatus());
        for (ProductRequest productRequest : request.getProducts()) {
            log.info("Product info= {}", productRequest.getProductName());
        }
    }

}
