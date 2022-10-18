package com.example.fraud.Service;

import com.example.fraud.Entities.Fraud;
import com.example.fraud.Repository.FraudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FraudService {

    @Autowired
    private FraudRepository fraudRepository;

    public boolean isFraudulentCustomer(Long customerId){
        fraudRepository.save(
                Fraud.builder()
                        .customerId(customerId)
                        .isFrauster(false)
                        .createdAt(LocalDateTime.now())
                        .build());
        return false;
    }
}
