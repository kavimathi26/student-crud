package com.college.data.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
public class Address {

    @Field(name = "door_number")
    @JsonProperty("Door Number")
    private short doorNumber;
    @Field(name = "street_name")
    @JsonProperty("Street Name")
    private String streetName;
    @Field(name = "city_name")
    @JsonProperty("City Name")
    private String cityName;
    @Field(name = "district")
    @JsonProperty("District")
    private String district;
    @Field(name = "pin_code")
    @JsonProperty("Pin Code")
    private int pinCode;
}
