package com.college.data.service;

import com.college.data.entity.ApiResponse;
import com.college.data.entity.StudentPersonalDetails;
import org.springframework.http.ResponseEntity;

public interface StudentCompleteDetailsService {
    ResponseEntity<ApiResponse> ViewStudentCompleteDetails(String rollNo);

}
