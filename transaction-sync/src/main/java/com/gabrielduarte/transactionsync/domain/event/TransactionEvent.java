package com.gabrielduarte.transactionsync.domain.event;

import com.gabrielduarte.transactionsync.domain.Status;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class TransactionEvent {

    private BigDecimal value;

    private Status status;

    private Long swapiUserId;

    private List<ProductEvent> products;

}
