package com.college.data.dao;

import com.college.data.entity.ApiResponse;
import com.college.data.entity.StudentPersonalDetails;
import org.springframework.http.ResponseEntity;

public interface StudentPersonalDetailsDAO {
    String PERSONAL = "student_personal_details";

    boolean checkForDuplicates(StudentPersonalDetails studentPersonalDetails);
    void enrollStudentPersonalDetails(StudentPersonalDetails studentPersonalDetails);
}
