package com.gabrielduarte.transactionapi.controller;

import com.gabrielduarte.transactionapi.domain.Transaction;
import com.gabrielduarte.transactionapi.service.TransactionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionalController {

    private final TransactionService service;

    public TransactionalController(TransactionService service) {
        this.service = service;
    }

    @PostMapping
    public void createTransaction(@RequestBody Transaction transaction) {
        service.createTransaction();
    }
}
