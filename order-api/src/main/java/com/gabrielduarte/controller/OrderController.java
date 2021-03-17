package com.gabrielduarte.controller;

import com.gabrielduarte.request.OrderRequest;
import com.gabrielduarte.request.ProductRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequestMapping("/order")
public class OrderController {

    @PostMapping
    public void createOrder(final OrderRequest request) {
        log.info("request received");
        log.info("request id= {}", request.getId());
        log.info("Status = {}", request.getStatus());
        for (ProductRequest productRequest : request.getProducts()) {
            log.info("Product info= {}", productRequest.getProductName());
        }
    }

}
