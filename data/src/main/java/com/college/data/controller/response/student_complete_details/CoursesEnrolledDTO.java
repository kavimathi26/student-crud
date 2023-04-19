package com.college.data.controller.response.student_complete_details;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
@Data
public class CoursesEnrolledDTO {
    private String courseRegulationCode;
    private String courseTitle1;
    private String courseCredit;
    private String courseBranch;
    List<FacultyDetailsDTO> facultyDetails;
}
