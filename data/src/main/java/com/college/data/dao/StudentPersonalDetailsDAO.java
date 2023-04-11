package com.college.data.dao;

import com.college.data.entity.StudentPersonalDetails;

public interface StudentPersonalDetailsDAO {
    String PERSONAL = "student_personal_details";
    StudentPersonalDetails findStudentDetail(StudentPersonalDetails studentPersonalDetails);

    void enrollStudentPersonalDetails(StudentPersonalDetails studentPersonalDetails);
}
