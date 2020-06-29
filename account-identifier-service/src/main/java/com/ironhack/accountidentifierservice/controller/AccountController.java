package com.ironhack.accountidentifierservice.controller;

import com.ironhack.accountidentifierservice.dto.AccountIdentifier;
import com.ironhack.accountidentifierservice.enums.AccountType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class AccountController {
    @Autowired
    private Environment environment;


    Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

    @GetMapping(path = "account-identifier/{accountType}")
    public AccountIdentifier getAccountIdentifier(@PathVariable("accountType") AccountType accountType) {
        Random random = new Random(System.currentTimeMillis());
        int randomId = 10000 +  random.nextInt(20000);
        LOGGER.info("account-identifier-service running on port ======>" + environment.getProperty("local.server.port"));
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
