package com.college.data.controller.response.student_complete_details;

import com.college.data.entity.CourseEnrolledByStudent;
import com.college.data.entity.StudentAcademicDetails;
import com.college.data.entity.StudentPersonalDetails;

import java.util.List;

public class StudentCompleteDetailsDTO {
    StudentPersonalDetailsDTO studentPersonalDetails;
    StudentAcademicDetailsDTO studentAcademicDetails;
    List<CoursesEnrolledDTO> coursesEnrolled;


}
