package com.college.data.entity;

import com.college.data.dao.FacultyAvailableDAO;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Document(collection = FacultyAvailableDAO.FACULTY)

public class FacultyDetails{
    @Field(name = "faculty_id")
    private String facultyId;
    @Field(name = "name")
    private String name;
    @Field(name = "degree")
    private String degree;
    @Field(name = "dob")
    private Date dob;
    @Field(name = "passed_out_year")
    private String passedOutYear;
    @Field(name = "department")
    private String department;
    @Field(name = "designation")
    private String designation;
    @Field(name = "courses_handled")
    private List<String> coursesHandled;

}
