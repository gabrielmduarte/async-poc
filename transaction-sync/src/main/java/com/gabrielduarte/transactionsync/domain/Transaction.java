package com.gabrielduarte.transactionsync.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Transaction {

    private Long id;

    private BigDecimal value;

    private Status status;

    private Long swapiUserId;

    private List<Product> products;

}
