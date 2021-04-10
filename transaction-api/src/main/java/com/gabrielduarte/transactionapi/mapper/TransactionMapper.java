package com.gabrielduarte.transactionapi.mapper;

import com.gabrielduarte.transactionapi.domain.TransactionEntity;
import com.gabrielduarte.transactionapi.domain.event.TransactionEvent;
import com.gabrielduarte.transactionapi.domain.request.TransactionRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(uses = ProductMapper.class,
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TransactionMapper {

    TransactionEntity toEntity(final TransactionRequest request);

    TransactionEvent toEvent(final TransactionRequest request);

}
