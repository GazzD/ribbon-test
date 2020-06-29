package com.ironhack.bankaccountservice.config;

import feign.*;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
public class FeignConfiguration {

    @Bean
    public Logger.Level configureLogLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public Request.Options timeoutConfiguration() {
        return new Request.Options(5000, 300000);
    }

    @Bean
    public RequestInterceptor headerRequestInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate requestTemplate) {
                org.slf4j.Logger LOGGER = LoggerFactory.getLogger(FeignConfiguration.class);
                LOGGER.info("Adding test header :D");
                requestTemplate.header("testHeader", "testValue");

            }
        };
    }

    @Bean
    public Retryer retryer() {
        // the first param is the starting wait time before retrying, the second is the max wait time before retrying, the third is the max number of retry attempts
        return new Retryer.Default(1000, 8000, 3);
    }
}
