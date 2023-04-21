package com.college.data.controller.response.student_complete_details;

import com.college.data.entity.Address;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
@Data
public class StudentPersonalDetailsDTO {
    @JsonProperty("Roll no")
    private String rollNo;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Batch")
    private short batch;
    @JsonProperty("Gender")
    private String gender;
    @JsonProperty("Blood Group")
    private String bloodGroup;
    @JsonProperty("Date Of Birth")
    private LocalDate dateOfBirth;
    @JsonProperty("Nationality")
    private String nationality;
    @JsonProperty("Email Id")
    private String emailId;
    @JsonProperty("Phone Number")
    private long phoneNumber;
    @JsonProperty("Mother Tongue")
    private String motherTongue;
    @JsonProperty("Aadhar Number")
    private long aadharNo;
    @JsonProperty("Address")
    private Address address;
    @JsonProperty("Father Name")
    private String fatherName;
    @JsonProperty("Mother Name")
    private String motherName;
}
