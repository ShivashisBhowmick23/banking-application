package com.boot.banking.service;

import com.boot.banking.model.Account;
import com.boot.banking.model.Transaction;
import com.boot.banking.repository.AccountRepository;
import com.boot.banking.repository.TransactionRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankingService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccountById(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

    @Transactional
    public Transaction makeTransaction(Transaction transaction) {
        Account account = transaction.getAccount();
        double transactionAmount = transaction.getAmount();

        // Ensure the account exists
        if (account == null) {
            throw new IllegalArgumentException("Invalid account");
        }

        // Ensure sufficient balance for withdrawal transactions
        if (transactionAmount < 0 && account.getBalance() + transactionAmount < 0) {
            throw new IllegalStateException("Insufficient balance");
        }

        // Update account balance
        account.setBalance(account.getBalance() + transactionAmount);
        accountRepository.save(account);

        // Save transaction
        return transactionRepository.save(transaction);
    }

    @Transactional
    public Transaction makeDeposit(Long accountId, double amount) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));

        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid deposit amount");
        }

        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);

        Transaction transaction = new Transaction();
        transaction.setAccount(account);
        transaction.setAmount(amount);
        return transactionRepository.save(transaction);
    }

    @Transactional
    public Transaction makeWithdrawal(Long accountId, double amount) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));

        if (amount <= 0 || account.getBalance() < amount) {
            throw new IllegalArgumentException("Invalid withdrawal amount or insufficient balance");
        }

        account.setBalance(account.getBalance() - amount);
        accountRepository.save(account);

        Transaction transaction = new Transaction();
        transaction.setAccount(account);
        transaction.setAmount(-amount); // Negative amount for withdrawal
        return transactionRepository.save(transaction);
    }

    @Transactional
    public Transaction makeTransfer(Long fromAccountId, Long toAccountId, double amount) {
        if (fromAccountId.equals(toAccountId)) {
            throw new IllegalArgumentException("Cannot transfer to the same account");
        }

        Account fromAccount = accountRepository.findById(fromAccountId)
                .orElseThrow(() -> new IllegalArgumentException("From Account not found"));
        Account toAccount = accountRepository.findById(toAccountId)
                .orElseThrow(() -> new IllegalArgumentException("To Account not found"));

        if (amount <= 0 || fromAccount.getBalance() < amount) {
            throw new IllegalArgumentException("Invalid transfer amount or insufficient balance");
        }

        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);

        Transaction transaction = new Transaction();
        transaction.setAccount(fromAccount);
        transaction.setAmount(-amount); // Negative amount for transfer
        return transactionRepository.save(transaction);
    }

    public double checkBalance(Long accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new EntityNotFoundException("Account not found with id: " + accountId));
        return account.getBalance();
    }
}

