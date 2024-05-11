package com.boot.banking.request;

import lombok.Data;

@Data
public class DepositRequest {
    private Long accountId;
    private double amount;
}
