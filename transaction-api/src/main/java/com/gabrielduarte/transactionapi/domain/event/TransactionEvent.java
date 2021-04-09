package com.gabrielduarte.transactionapi.domain.event;

import com.gabrielduarte.transactionapi.domain.Status;
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
