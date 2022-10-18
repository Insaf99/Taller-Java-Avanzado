package com.example.fraud.Controller;

import com.example.fraud.Entities.FraudResponse;
import com.example.fraud.Service.FraudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/fraud-check")
@Slf4j
public class FraudController {

    @Autowired
    private FraudService fraudService;

    @GetMapping("/{customerId}")
    public FraudResponse isFraudster(@PathVariable("customerId") Long customerId){
        boolean isFraudulentCustomer = fraudService.isFraudulentCustomer(customerId);
        log.info("fraud check request for customer {}",customerId);
        return new FraudResponse(isFraudulentCustomer);
    }

}
