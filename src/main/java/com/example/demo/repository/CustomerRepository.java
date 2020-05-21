package com.example.demo.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.example.demo.entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {

    private DynamoDBMapper dynamoDBMapper;

    @Autowired
    public CustomerRepository(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public void createCustomer(CustomerEntity customer) {
        dynamoDBMapper.save(customer);
    }

    public CustomerEntity getCustomer(String customerId) {
        return dynamoDBMapper.load(CustomerEntity.class, customerId);
    }
}
