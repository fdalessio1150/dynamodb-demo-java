package com.example.demo.controller;

import com.example.demo.model.CustomerDTO;
import com.example.demo.model.Data;
import com.example.demo.service.CustomerService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
public class Controller {

    public CustomerService customerService;

    public Controller(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "/v1/customer/{customerId}")
    public Data<CustomerDTO> getClients(@PathVariable String customerId) {
        return new Data(customerService.getCustomers(customerId));
    }

    @PostMapping(path = "/v1/customer")
    public ResponseEntity createCustomer(@RequestBody @Validated @NotNull CustomerDTO body) {
        customerService.createCustomer(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(body);
    }

}
