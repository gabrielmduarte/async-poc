package com.gabrielduarte.transactionapi.controller;

import com.gabrielduarte.transactionapi.request.TransactionRequest;
import com.gabrielduarte.transactionapi.service.TransactionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionalController {

    private final TransactionService service;

    public TransactionalController(final TransactionService service) {
        this.service = service;
    }

    @PostMapping
    public void createTransaction(@RequestBody final TransactionRequest transaction) {
        service.createTransaction(transaction);
    }

}
