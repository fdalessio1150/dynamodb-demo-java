package com.example.demo.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.example.demo.model.CustomerDTO;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@DynamoDBTable(tableName="customer")
public class CustomerEntity {

    private String customerId;
    private String payload;

    public CustomerEntity() { }

    public CustomerEntity(CustomerDTO customerDTO){
        this.customerId = customerDTO.getId();
        this.payload = customerDTO.getPayload();
    }

    @DynamoDBHashKey(attributeName = "customerId")
    public String getCustomerId()   {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @DynamoDBAttribute(attributeName = "payload")
    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

}