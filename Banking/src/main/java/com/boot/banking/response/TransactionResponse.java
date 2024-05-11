package com.boot.banking.response;

import lombok.Data;

@Data
public class TransactionResponse {
    private Long transactionId;
    private double amount;
    private Long accountId;

}
