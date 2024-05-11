package com.boot.banking.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Transaction_tbl")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double amount;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;


}
