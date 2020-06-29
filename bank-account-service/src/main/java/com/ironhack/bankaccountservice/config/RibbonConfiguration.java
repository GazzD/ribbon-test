package com.ironhack.bankaccountservice.config;

import com.netflix.loadbalancer.*;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RibbonConfiguration {

    @Bean
    public IRule loadBalancingRule() {
//        return new WeightedResponseTimeRule();
//        return new AvailabilityFilteringRule();
        return new RoundRobinRule();
//        return new RandomRule();
    }
}
