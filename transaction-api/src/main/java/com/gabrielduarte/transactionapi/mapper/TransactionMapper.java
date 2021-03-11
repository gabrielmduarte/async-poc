package com.gabrielduarte.transactionapi.mapper;

import com.gabrielduarte.transactionapi.domain.Transaction;
import com.gabrielduarte.transactionapi.request.TransactionRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(uses = ProductMapper.class,
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TransactionMapper {

    Transaction toEntity(final TransactionRequest request);

}
