package com.courses.microservices.controller;

import com.courses.microservices.bean.LimitConfiguration;
import com.courses.microservices.config.Configuration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public LimitConfiguration retrieveLimitsFromConfigurations() {
        return new LimitConfiguration(configuration.getMinimum(), configuration.getMaximum());
    }

    @GetMapping("/fault-tolerance")
    @HystrixCommand(fallbackMethod = "fallbackRetrieveConfiguration")
    public LimitConfiguration retrieveConfiguration() {
        throw new RuntimeException("Not Available");
    }

    public LimitConfiguration fallbackRetrieveConfiguration() {
        return new LimitConfiguration(9,999);
    }
}
