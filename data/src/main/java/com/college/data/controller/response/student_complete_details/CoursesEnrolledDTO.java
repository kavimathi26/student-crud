package com.college.data.controller.response.student_complete_details;

import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

public class CoursesEnrolledDTO {
    @Field(name = "course_regulation_code")
    private String courseRegulationCode;
    @Field(name = "course_title")
    private String courseTitle1;
    @Field(name = "course_credit")
    private String courseCredit;
    @Field(name = "course_branch")
    private String courseBranch;
    List<FacultyDetailsDTO> facultyDetails;
}
