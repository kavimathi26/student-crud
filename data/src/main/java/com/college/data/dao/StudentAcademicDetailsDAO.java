package com.college.data.dao;

import com.college.data.entity.StudentAcademicDetails;

import java.util.List;

public interface StudentAcademicDetailsDAO {
    String ACADEMIC =  "student_academic_details";
    StudentAcademicDetails findStudentDetail(String rollNo);

    void enrollStudentAcademicDetails(StudentAcademicDetails studentAcademicDetails);
}
