package com.gabrielduarte.transactionsync.mapper;

import com.gabrielduarte.transactionsync.domain.Transaction;
import com.gabrielduarte.transactionsync.request.OrderRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring",
        uses = ProductMapper.class)
public interface OrderMapper {

    OrderRequest toOrderRequest(Transaction transaction);

}
