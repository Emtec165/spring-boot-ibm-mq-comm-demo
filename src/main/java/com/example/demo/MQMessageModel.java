package com.example.demo;

import lombok.Data;

import java.io.Serializable;

@Data
class MQMessageModel implements Serializable {

    private String firstName;
    private String lastName;
    private Integer age;
}
