package com.ironhack.accountidentifierservice.controller;

import com.ironhack.accountidentifierservice.dto.AccountIdentifier;
import com.ironhack.accountidentifierservice.enums.AccountType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class AccountController {

    @GetMapping(path = "account-identifier/{accountType}")
    public AccountIdentifier getAccountIdentifier(@PathVariable("accountType") AccountType accountType) {
        Random random = new Random(System.currentTimeMillis());
        int randomId = 10000 +  random.nextInt(20000);

        AccountIdentifier accountIdentifier = new AccountIdentifier();

        switch (accountType) {
            case CURRENT_ACCOUNT:
                accountIdentifier.setAccountNumber("C" + randomId);
                break;
            case SAVINGS_ACCOUNT:
                accountIdentifier.setAccountNumber("S" + randomId);
                break;
            default:
                accountIdentifier.setAccountNumber("D" + randomId);
                break;
        }
        return accountIdentifier;

    }
}
