package com.gabrielduarte.transactionapi.mapper;

import com.gabrielduarte.transactionapi.domain.Product;
import com.gabrielduarte.transactionapi.request.ProductRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    Product toEntity(final ProductRequest request);

}
