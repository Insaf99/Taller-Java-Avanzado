package com.example.customer.Service;


import com.example.customer.Entities.Customer;
import com.example.customer.Entities.CustomerRegistrationRequest;
import com.example.customer.Entities.FraudResponse;
import com.example.customer.Repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RestTemplate restTemplate;

    public void registerCustomer(CustomerRegistrationRequest request){
        Customer customer = Customer.builder()
                .nombre(request.getNombre())
                .apellido(request.getApellido())
                .email(request.getEmail())
                .build();

        customerRepository.saveAndFlush(customer);

        FraudResponse response = restTemplate.getForObject(
                "http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudResponse.class,
                customer.getId()
        );

        if(response.isFraudster()){
            throw new IllegalStateException("fraudster");
        }
    }
}
