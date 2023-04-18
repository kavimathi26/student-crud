package com.college.data.controller.response.student_complete_details;

import com.college.data.entity.Address;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Date;

public class StudentPersonalDetailsDTO {
    @NotBlank(message = "roll no may not be blank")
    @Field(name = "roll_no")//remove
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
    @Field(name = "created_at")
    private Date createdAt;
    @Field(name = "updated_at")
    private Date updatedAt;
    @Field(name = "status")
    private String status;
}
