package com.college.data.dao;

import com.college.data.entity.StudentPersonalDetails;

import java.util.List;

public interface StudentPersonalDetailsDAO {
    String PERSONAL = "student_personal_details";
    StudentPersonalDetails findStudentDetail(String rollNo);

    void enrollStudentPersonalDetails(StudentPersonalDetails studentPersonalDetails);
}
