package com.gabrielduarte.transactionsync.request;

import com.gabrielduarte.transactionsync.domain.Status;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderRequest {

    private BigDecimal value;

    private Status status;

    private Long swapiUserId;

    private List<ProductRequest> products;

}
