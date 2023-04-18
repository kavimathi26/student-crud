package com.college.data.entity;

import lombok.Data;

@Data
public class StudentCompleteDetails {
    private StudentPersonalDetails studentPersonalDetails;
    private StudentAcademicDetails studentAcademicDetails;
    private CoursesAvailable coursesAvailable;
    private FacultyDetails facultyDetails;
}
