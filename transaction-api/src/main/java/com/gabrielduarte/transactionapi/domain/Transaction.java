package com.gabrielduarte.transactionapi.domain;

import lombok.Data;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
public class Transaction {

    private Long id;
    private BigDecimal value;
    private Status status;
    private Long swapiUserId;
    private List<Products> products;
}
