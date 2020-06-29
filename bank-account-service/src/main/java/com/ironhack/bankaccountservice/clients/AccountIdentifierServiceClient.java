package com.ironhack.bankaccountservice.clients;

import com.ironhack.bankaccountservice.config.FeignConfiguration;
import com.ironhack.bankaccountservice.dto.AccountIdentifier;
import com.ironhack.bankaccountservice.enums.AccountType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "account-identifier-service", configuration = FeignConfiguration.class)
public interface AccountIdentifierServiceClient {
    @GetMapping(path = "account-identifier/{accountType}")
    public AccountIdentifier getAccountIdentifier(@PathVariable("accountType") AccountType accountType);
}
