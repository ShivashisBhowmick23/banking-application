package com.boot.banking.request;

import lombok.Data;

@Data
public class WithdrawalRequest {
    private Long accountId;
    private double amount;
}
