package com.college.data.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection = "student_academic_details")

public class StudentAcademicDetails {
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
    private List<CourseEnrolledByStudent> listOfCoursesEnrolled;

}
