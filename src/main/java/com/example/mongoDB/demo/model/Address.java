package com.example.mongoDB.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {

    private String country;
    private String postCode;
    private String city;
}
