package com.college.data.controller.response.student_complete_details;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

import java.util.List;
@Data
@JsonRootName(value = "StudentCompleteDetails")
public class StudentCompleteDetailsDTO {
    @JsonProperty("Student Personal Details")
    StudentPersonalDetailsDTO studentPersonalDetails;
    @JsonProperty("Student Academic Details")
    StudentAcademicDetailsDTO studentAcademicDetails;
    @JsonProperty("Courses Enrolled")
    List<CoursesEnrolledDTO> coursesEnrolled;
}
