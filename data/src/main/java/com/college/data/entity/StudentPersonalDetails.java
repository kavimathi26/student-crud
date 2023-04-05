package com.college.data.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
//@Data
@Getter
@Setter
@Document(collection = "student_personal_details")

public class StudentPersonalDetails {
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
