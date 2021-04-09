package com.gabrielduarte.transactionapi.domain.request;

import com.gabrielduarte.transactionapi.domain.Status;
import com.gabrielduarte.transactionapi.domain.request.ProductRequest;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class TransactionRequest {

    private BigDecimal value;

    private Status status;

    private Long swapiUserId;

    private List<ProductRequest> products;

}
