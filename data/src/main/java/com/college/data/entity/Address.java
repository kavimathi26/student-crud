package com.college.data.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
public class Address {

    @Field(name = "door_number")
    private short doorNumber;
    @Field(name = "street_name")
    private String streetName;
    @Field(name = "city_name")
    private String cityName;
    @Field(name = "district")
    private String district;
    @Field(name = "pin_code")
    private int pinCode;
}
