package com.college.data.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
public class Address {

    @Field("xyz")
    private short doorNumber;
    private String streetName;
    private String cityName;
    private String district;
    private int pinCode;
}
