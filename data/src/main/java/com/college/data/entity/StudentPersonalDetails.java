package com.college.data.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
//@Data
@Getter
@Setter
@Document(collection = "student_personal_details")

public class StudentPersonalDetails {
        @NotBlank
        @Field(name = "roll_no")
        private String rollNo;
        @NotBlank
        @Field(name = "name")
        private String name;
        @Field(name = "batch")
        private short batch;
        @Field("gender")
        private String gender;
        @Field(name = "blood_group")
        private String bloodGroup;
        @Field(name = "date_of_birth")
        private LocalDate dateOfBirth;
        @Field(name = "nationality")
        private String nationality;
        @Field(name = "email_id")
        private String emailId;
        @Field(name = "phone_number")
        private long phoneNumber;
        @Field(name = "mother_tongue")
        private String motherTongue;
        @Field(name = "aadhar_no")
        private long aadharNo;
        @Field(name = "address")
        private Address address;
        @Field(name = "father_name")
        private String fatherName;
        @Field(name = "mother_name")
        private String motherName;
}
