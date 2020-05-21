package com.example.demo.model;

import com.example.demo.entity.CustomerEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;

public class CustomerDTO {

    public CustomerDTO() { }

    public CustomerDTO(CustomerEntity entity) {
        this.id = entity.getCustomerId();
        this.payload = entity.getPayload();
    }

    @NotNull
    @JsonProperty("id")
    private String id;

    @NotNull
    @JsonProperty("payload")
    private String payload;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
}
