package com.college.data.dao;

import com.college.data.entity.StudentPersonalDetails;

public interface StudentPersonalDetailsDAO {
    String PERSONAL = "student_personal_details";


    void enrollStudentPersonalDetails(StudentPersonalDetails studentPersonalDetails);
}
