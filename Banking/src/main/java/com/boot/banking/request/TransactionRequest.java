package com.boot.banking.request;

import lombok.Data;

@Data
public class TransactionRequest {
    private Long accountId;
    private Long destinationAccountId;
    private double amount;

}
