package com.college.data.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "faculty_details")

public class FacultyDetails {
    public FacultyDetails(String facultyId, String name, String degree, LocalDate dob, String passedOutYear, String department, String designation, List<String> coursesHandled) {
        this.facultyId = facultyId;
        this.name = name;
        this.degree = degree;
        this.dob = dob;
        this.passedOutYear = passedOutYear;
        this.department = department;
        this.designation = designation;
        this.coursesHandled = coursesHandled;
    }

    private String facultyId;
    private String name;
    private String degree;
    private LocalDate dob;
    private String passedOutYear;
    private String department;
    private String designation;
    private List<String> coursesHandled;

    public String getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getPassedOutYear() {
        return passedOutYear;
    }

    public void setPassedOutYear(String passedOutYear) {
        this.passedOutYear = passedOutYear;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public List<String> getCoursesHandled() {
        return coursesHandled;
    }

    public void setCoursesHandled(List<String> coursesHandled) {
        this.coursesHandled = coursesHandled;
    }
}
