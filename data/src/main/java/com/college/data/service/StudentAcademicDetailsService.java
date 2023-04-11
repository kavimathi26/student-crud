package com.college.data.service;

import com.college.data.entity.ApiResponse;
import com.college.data.entity.StudentAcademicDetails;
import org.springframework.http.ResponseEntity;

public interface StudentAcademicDetailsService {

    ResponseEntity<ApiResponse> enrollStudentAcademicDetails(StudentAcademicDetails studentAcademicDetails);
}
