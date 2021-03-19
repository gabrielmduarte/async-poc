package com.gabrielduarte.request;

import com.gabrielduarte.domain.Status;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderRequest {

    private Long id;

    private BigDecimal value;

    private Status status;

    private Long swapiUserId;

    private List<ProductRequest> products;
}
