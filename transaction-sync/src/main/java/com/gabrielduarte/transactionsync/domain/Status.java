package com.gabrielduarte.transactionsync.domain;

public enum Status {

    APPROVED("Approved"),
    DELAYED("Delayed"),
    CANCELED("Canceled"),
    REVIEW("In review");

    private final String status;

    Status(final String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
