package com.gabrielduarte.transactionapi.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface TransactionDoneChannel {

    String TRANSACTION_DONE_OUTPUT = "transaction-done-output";

    @Output(TRANSACTION_DONE_OUTPUT)
    MessageChannel output();

}
