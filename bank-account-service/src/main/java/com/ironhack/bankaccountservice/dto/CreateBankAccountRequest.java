package com.ironhack.bankaccountservice.dto;

import com.ironhack.bankaccountservice.enums.AccountType;

import java.math.BigDecimal;

public class CreateBankAccountRequest {
    private String owner;
    private BigDecimal balance;
    private AccountType accountType;

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
