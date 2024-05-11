package com.boot.banking.controller;

import com.boot.banking.model.Transaction;
import com.boot.banking.request.DepositRequest;
import com.boot.banking.request.TransactionRequest;
import com.boot.banking.request.TransferRequest;
import com.boot.banking.request.WithdrawalRequest;
import com.boot.banking.response.TransactionResponse;
import com.boot.banking.service.BankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private BankingService bankingService;

    @PostMapping("/make")
    public ResponseEntity<TransactionResponse> makeTransaction(@RequestBody TransactionRequest request) {
        // Assuming accountId exists, handle validation as needed
        Transaction transaction = new Transaction();
        transaction.setAccount(bankingService.getAccountById(request.getAccountId()));
        transaction.setAmount(request.getAmount());

        Transaction createdTransaction = bankingService.makeTransaction(transaction);

        TransactionResponse response = new TransactionResponse();
        response.setTransactionId(createdTransaction.getId());
        response.setAmount(createdTransaction.getAmount());
        response.setAccountId(createdTransaction.getAccount().getId());

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/deposit")
    public ResponseEntity<TransactionResponse> makeDeposit(@RequestBody DepositRequest request) {
        Transaction transaction = bankingService.makeDeposit(request.getAccountId(), request.getAmount());
        return new ResponseEntity<>(createResponse(transaction), HttpStatus.CREATED);
    }

    @PostMapping("/withdraw")
    public ResponseEntity<TransactionResponse> makeWithdrawal(@RequestBody WithdrawalRequest request) {
        Transaction transaction = bankingService.makeWithdrawal(request.getAccountId(), request.getAmount());
        return new ResponseEntity<>(createResponse(transaction), HttpStatus.CREATED);
    }

    @PostMapping("/transfer")
    public ResponseEntity<TransactionResponse> makeTransfer(@RequestBody TransferRequest request) {
        Transaction transaction = bankingService.makeTransfer(request.getFromAccountId(), request.getToAccountId(), request.getAmount());
        return new ResponseEntity<>(createResponse(transaction), HttpStatus.CREATED);
    }

    private TransactionResponse createResponse(Transaction transaction) {
        TransactionResponse response = new TransactionResponse();
        response.setTransactionId(transaction.getId());
        response.setAmount(transaction.getAmount());
        response.setAccountId(transaction.getAccount().getId());
        return response;
    }
}


