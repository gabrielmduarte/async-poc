package com.gabrielduarte.transactionsync.mapper;

import com.gabrielduarte.transactionsync.domain.Product;
import com.gabrielduarte.transactionsync.domain.Transaction;
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
    public OrderRequest toOrderRequest(Transaction transaction) {
        if ( transaction == null ) {
            return null;
        }

        OrderRequest orderRequest = new OrderRequest();

        orderRequest.setValue( transaction.getValue() );
        orderRequest.setStatus( transaction.getStatus() );
        orderRequest.setSwapiUserId( transaction.getSwapiUserId() );
        orderRequest.setProducts( productListToProductRequestList( transaction.getProducts() ) );

        return orderRequest;
    }

    protected List<ProductRequest> productListToProductRequestList(List<Product> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductRequest> list1 = new ArrayList<ProductRequest>( list.size() );
        for ( Product product : list ) {
            list1.add( productMapper.toProductRequest( product ) );
        }

        return list1;
    }
}
