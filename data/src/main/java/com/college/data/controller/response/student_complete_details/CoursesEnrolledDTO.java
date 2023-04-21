package com.college.data.controller.response.student_complete_details;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data

public class CoursesEnrolledDTO {
//    @JsonProperty("Course Regulation Code")
    private String courseRegulationCode;
//    @JsonProperty("Course Title")
    private String courseTitle;
//    @JsonProperty("Course Credit")
    private String courseCredit;
//    @JsonProperty("Course Branch")
    private String courseBranch;
//    @JsonProperty("Faculty Details")
    FacultyDetailsDTO facultyDetails;
}
