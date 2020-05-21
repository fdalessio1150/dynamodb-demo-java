package com.example.demo.model;

import javax.validation.Valid;

public class Data<T> {

    @Valid
    private T data;

    public Data() {}

    public Data(T data){
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
