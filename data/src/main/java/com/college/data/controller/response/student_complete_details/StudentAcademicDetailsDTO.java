package com.college.data.controller.response.student_complete_details;

import com.college.data.entity.CourseEnrolledByStudent;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

public class StudentAcademicDetailsDTO {
    @Field(name = "roll_no")
    private String rollNo;
    @Field(name = "department")
    private String department;
    @Field(name = "course_code")
    private String courseCode;
    @Field(name = "degree_level")
    private String degreeLevel;
    @Field(name = "course_starting_year")
    private short courseStartingYear;
    @Field(name = "course_ending_year")
    private short courseEndingYear;
    @Field(name = "current_year")
    private short currentYear;
    @Field(name = "current_semester")
    private short currentSemester;
    @Field(name = "student_type")
    private String studentType;
    @Field(name = "regulation")
    private short regulation;
    @Field(name = "university")
    private String university;
    @Field(name = "grade")
    private String grade;
    @Field(name = "cgpa")
    private double cgpa;
}
