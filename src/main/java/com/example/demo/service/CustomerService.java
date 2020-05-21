package com.example.demo.service;

import com.example.demo.entity.CustomerEntity;
import com.example.demo.model.CustomerDTO;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class CustomerService {

    private CustomerRepository customerRepo;

    @Autowired
    public CustomerService(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }


    public CustomerDTO getCustomers(String customerId) {
        CustomerEntity entity = customerRepo.getCustomer(customerId);

        return new CustomerDTO(entity);
    }

    public void createCustomer(CustomerDTO customerDTO) {
        customerRepo.createCustomer(new CustomerEntity(customerDTO));
    }
}
