package com.college.data.controller.response.student_complete_details;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName(value = "StudentAcademicDetails")
public class StudentAcademicDetailsDTO {
    @JsonProperty("Roll No")
    private String rollNo;
    @JsonProperty("Department")
    private String department;
    @JsonProperty("Course Code")
    private String courseCode;
    @JsonProperty("Degree Level")
    private String degreeLevel;
    @JsonProperty("Course Starting Year")
    private short courseStartingYear;
    @JsonProperty("Course Ending Year")
    private short courseEndingYear;
    @JsonProperty("Current Year")
    private short currentYear;
    @JsonProperty("Current Semester")
    private short currentSemester;
    @JsonProperty("Student Type")
    private String studentType;
    @JsonProperty("Regulation")
    private short regulation;
    @JsonProperty("University")
    private String university;
    @JsonProperty("Grade")
    private String grade;
    @JsonProperty("CGPA")
    private double cgpa;
}
