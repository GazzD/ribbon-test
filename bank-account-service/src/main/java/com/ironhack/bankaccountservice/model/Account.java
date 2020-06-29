package com.ironhack.bankaccountservice.model;

import com.ironhack.bankaccountservice.enums.AccountType;

import java.math.BigDecimal;

public class Account {
    private String accountNumber;
    private String owner;
    private BigDecimal balance;
    private AccountType accountType;

    public Account(String accountNumber, String owner, BigDecimal balance, AccountType accountType) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
}
