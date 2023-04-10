package com.college.data.dao;

import com.college.data.entity.StudentAcademicDetails;

public interface StudentAcademicDetailsDAO {
    String ACADEMIC =  "student_academic_details";

    void enrollStudentAcademicDetails(StudentAcademicDetails studentAcademicDetails);
}
