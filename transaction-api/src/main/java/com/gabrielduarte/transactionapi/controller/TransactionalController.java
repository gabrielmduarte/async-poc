package com.gabrielduarte.transactionapi.controller;

import com.gabrielduarte.transactionapi.domain.request.TransactionRequest;
import com.gabrielduarte.transactionapi.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
@AllArgsConstructor
public class TransactionalController {

    private final TransactionService service;

    @PostMapping
    public void createTransaction(@RequestBody final TransactionRequest transaction) {
        service.createTransaction(transaction);
    }

}
