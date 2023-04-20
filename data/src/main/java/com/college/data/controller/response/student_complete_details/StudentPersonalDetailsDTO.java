package com.college.data.controller.response.student_complete_details;

import com.college.data.entity.Address;
import lombok.Data;

import java.time.LocalDate;
@Data
public class StudentPersonalDetailsDTO {
    private String rollNo;
    private String name;
    private short batch;
    private String gender;
    private String bloodGroup;
    private LocalDate dateOfBirth;
    private String nationality;
    private String emailId;
    private long phoneNumber;
    private String motherTongue;
    private long aadharNo;
    private Address address;
    private String fatherName;
    private String motherName;
}
