package com.college.data.controller.response.student_complete_details;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

import java.util.List;
@Data
@JsonRootName(value = "StudentCompleteDetails")
public class StudentCompleteDetailsDTO {
    StudentPersonalDetailsDTO studentPersonalDetails;
    StudentAcademicDetailsDTO studentAcademicDetails;
    List<CoursesEnrolledDTO> coursesEnrolled;
}
