package com.ironhack.bankaccountservice.controller;

import com.ironhack.bankaccountservice.clients.AccountIdentifierServiceClient;
import com.ironhack.bankaccountservice.dto.AccountIdentifier;
import com.ironhack.bankaccountservice.dto.CreateBankAccountRequest;
import com.ironhack.bankaccountservice.enums.AccountType;
import com.ironhack.bankaccountservice.model.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class BankAccountController {

    @Autowired
    public AccountIdentifierServiceClient accountIdentifierServiceClient;

    @PostMapping("/account")
    public Account createBankAccount(@RequestBody CreateBankAccountRequest createBankAccountRequest) {
        AccountIdentifier accountIdentifier = accountIdentifierServiceClient.getAccountIdentifier(createBankAccountRequest.getAccountType());
        return new Account(accountIdentifier.getAccountNumber(), createBankAccountRequest.getOwner(), createBankAccountRequest.getBalance(), createBankAccountRequest.getAccountType());
    }
}
