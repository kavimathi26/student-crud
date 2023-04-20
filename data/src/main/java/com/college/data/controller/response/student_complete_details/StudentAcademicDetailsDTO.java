package com.college.data.controller.response.student_complete_details;

import lombok.Data;

@Data
public class StudentAcademicDetailsDTO {
    private String rollNo;
    private String department;
    private String courseCode;
    private String degreeLevel;
    private short courseStartingYear;
    private short courseEndingYear;
    private short currentYear;
    private short currentSemester;
    private String studentType;
    private short regulation;
    private String university;
    private String grade;
    private double cgpa;
}
