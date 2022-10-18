package com.example.fraud.Repository;

import com.example.fraud.Entities.Fraud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudRepository extends JpaRepository<Fraud,Long> {
}
