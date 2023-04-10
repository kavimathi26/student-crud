package com.college.data.entity;

import com.college.data.dao.FacultyAvailableDAO;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.List;


@Document(collection = FacultyAvailableDAO.FACULTY)

public class FacultyDetails{
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
