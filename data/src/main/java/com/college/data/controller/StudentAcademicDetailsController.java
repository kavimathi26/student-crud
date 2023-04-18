package com.college.data.controller;

import com.college.data.entity.ApiResponse;
import com.college.data.entity.StudentAcademicDetails;
import com.college.data.service.impl.StudentAcademicDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/studentAcademicDetails")
@RequiredArgsConstructor
public class StudentAcademicDetailsController {
    private final StudentAcademicDetailsServiceImpl studentAcademicDetailsServiceImpl;

    @PostMapping("/enroll")
    public ResponseEntity<ApiResponse> enrollStudentAcademicDetails(@RequestBody StudentAcademicDetails studentAcademicDetails) {
        return studentAcademicDetailsServiceImpl.enrollStudentAcademicDetails(studentAcademicDetails);
    }
}
