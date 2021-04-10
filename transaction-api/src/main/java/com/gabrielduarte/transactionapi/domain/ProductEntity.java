package com.gabrielduarte.transactionapi.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
    @SequenceGenerator(name = "product_sequence")
    private Long id;

    private String productName;

}
