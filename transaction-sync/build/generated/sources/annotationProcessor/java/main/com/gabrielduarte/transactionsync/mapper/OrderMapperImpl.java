package com.gabrielduarte.transactionsync.mapper;

import com.gabrielduarte.transactionsync.domain.event.ProductEvent;
import com.gabrielduarte.transactionsync.domain.event.TransactionEvent;
import com.gabrielduarte.transactionsync.request.OrderRequest;
import com.gabrielduarte.transactionsync.request.ProductRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-29T14:21:44-0300",
    comments = "version: 1.4.0.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-6.7.jar, environment: Java 15.0.1 (Azul Systems, Inc.)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public OrderRequest toOrderRequest(TransactionEvent transactionEvent) {
        if ( transactionEvent == null ) {
            return null;
        }

        OrderRequest orderRequest = new OrderRequest();

        orderRequest.setValue( transactionEvent.getValue() );
        orderRequest.setStatus( transactionEvent.getStatus() );
        orderRequest.setSwapiUserId( transactionEvent.getSwapiUserId() );
        orderRequest.setProducts( productListToProductRequestList( transactionEvent.getProductEvents() ) );

        return orderRequest;
    }

    protected List<ProductRequest> productListToProductRequestList(List<ProductEvent> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductRequest> list1 = new ArrayList<ProductRequest>( list.size() );
        for ( ProductEvent productEvent : list ) {
            list1.add( productMapper.toProductRequest(productEvent) );
        }

        return list1;
    }
}
