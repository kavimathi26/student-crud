package com.college.data.controller.response.student_complete_details;

import lombok.Data;

import java.util.List;
@Data

public class CoursesEnrolledDTO {

    private String courseRegulationCode;
    private String courseTitle;
    private String courseCredit;
    private String courseBranch;
    List<FacultyDetailsDTO> facultyDetails;
}
