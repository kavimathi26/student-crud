package com.college.data.controller.response.student_complete_details;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Data
public class FacultyDetailsDTO {
//    @JsonProperty("Faculty Id")
    private String facultyId;
//    @JsonProperty("Name")
    private String name;
//    @JsonProperty("Degree")
    private String degree;
//    @JsonProperty("D.O.B")
    private Date dob;
//    @JsonProperty("Passed Out Year")
    private String passedOutYear;
//    @JsonProperty("Department")
    private String department;
//    @JsonProperty("Designation")
    private String designation;
//    @JsonProperty("Courses Handled")
    private List<String> coursesHandled;
}
