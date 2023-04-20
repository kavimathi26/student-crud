package com.college.data.controller.response.student_complete_details;

import lombok.Data;

import java.util.List;
@Data
public class StudentCompleteDetailsDTO {
    StudentPersonalDetailsDTO studentPersonalDetails;
    StudentAcademicDetailsDTO studentAcademicDetails;
    List<CoursesEnrolledDTO> coursesEnrolled;
}
