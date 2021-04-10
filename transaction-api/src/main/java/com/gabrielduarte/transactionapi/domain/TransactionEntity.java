package com.gabrielduarte.transactionapi.domain;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_generator")
    @SequenceGenerator(name = "transaction_generator")
    private Long id;

    private BigDecimal value;

    private Status status;

    private Long swapiUserId;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<ProductEntity> products;

}
