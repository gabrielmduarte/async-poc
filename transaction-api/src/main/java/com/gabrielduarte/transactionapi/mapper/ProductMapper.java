package com.gabrielduarte.transactionapi.mapper;

import com.gabrielduarte.transactionapi.domain.ProductEntity;
import com.gabrielduarte.transactionapi.domain.event.ProductEvent;
import com.gabrielduarte.transactionapi.domain.request.ProductRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    ProductEntity toEntity(final ProductRequest request);

    ProductEvent toEvent(final ProductRequest request);

}
