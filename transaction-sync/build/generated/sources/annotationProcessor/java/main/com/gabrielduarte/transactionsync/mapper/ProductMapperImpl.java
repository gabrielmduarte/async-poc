package com.gabrielduarte.transactionsync.mapper;

import com.gabrielduarte.transactionsync.domain.event.ProductEvent;
import com.gabrielduarte.transactionsync.request.ProductRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-29T14:21:45-0300",
    comments = "version: 1.4.0.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-6.7.jar, environment: Java 15.0.1 (Azul Systems, Inc.)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductRequest toProductRequest(ProductEvent productEvent) {
        if ( productEvent == null ) {
            return null;
        }

        ProductRequest productRequest = new ProductRequest();

        productRequest.setProductName( productEvent.getProductName() );

        return productRequest;
    }
}
