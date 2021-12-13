package com.example.springdemo.dto;

public class IdDTO {
    private Integer id;

    public Integer getId() {
        System.out.println("i the value of the id is:" + this.id);
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
