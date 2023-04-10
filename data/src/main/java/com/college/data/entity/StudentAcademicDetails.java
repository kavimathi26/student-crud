package com.college.data.entity;

import com.college.data.dao.StudentAcademicDetailsDAO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Getter
@Setter
@Document(collection = StudentAcademicDetailsDAO.ACADEMIC)

public class StudentAcademicDetails{
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
    @Field(name = "list_of_courses_enrolled")
    private List<CourseEnrolledByStudent> listOfCoursesEnrolled;

}
