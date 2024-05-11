package com.boot.banking.request;

import lombok.Data;

@Data
public class TransferRequest {

    private Long fromAccountId;
    private Long toAccountId;
    private double amount;

    // getters and setters
}