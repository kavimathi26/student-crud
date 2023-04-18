package com.college.data.controller.response.student_complete_details;

import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.List;

public class FacultyDetailsDTO {
    @Field(name = "faculty_id")
    private String facultyId;
    @Field(name = "name")
    private String name;
    @Field(name = "degree")
    private String degree;
    @Field(name = "dob")
    private LocalDate dob;
    @Field(name = "passed_out_year")
    private String passedOutYear;
    @Field(name = "department")
    private String department;
    @Field(name = "designation")
    private String designation;
    @Field(name = "courses_handled")
    private List<String> coursesHandled;
}
