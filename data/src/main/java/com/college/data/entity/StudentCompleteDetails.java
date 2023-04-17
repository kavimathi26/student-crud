package com.college.data.entity;

import lombok.Data;

@Data
public class StudentCompleteDetails {
    StudentPersonalDetails studentPersonalDetails;
    StudentAcademicDetails studentAcademicDetails;
    CoursesAvailable coursesAvailable;
    FacultyDetails facultyDetails;
}
