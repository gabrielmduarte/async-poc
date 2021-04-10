package com.gabrielduarte.transactionsync.mapper;

import com.gabrielduarte.transactionsync.domain.event.ProductEvent;
import com.gabrielduarte.transactionsync.request.ProductRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    ProductRequest toProductRequest(ProductEvent productEvent);

}
