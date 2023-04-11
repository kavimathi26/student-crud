package com.college.data.controller;

import com.college.data.entity.ApiResponse;
import com.college.data.entity.StudentPersonalDetails;
import com.college.data.service.impl.StudentPersonalDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("studentPersonalDetails")
@RequiredArgsConstructor
public class StudentPersonalDetailsController {
    private final StudentPersonalDetailsServiceImpl studentPersonalDetailsServiceImpl;

    @PostMapping("/enroll")

    public ResponseEntity<ApiResponse> enrollStudentPersonalDetails(@RequestBody StudentPersonalDetails studentPersonalDetails) {
        ResponseEntity<ApiResponse> apiResponseResponseEntity = studentPersonalDetailsServiceImpl.enrollStudentPersonalDetails(studentPersonalDetails);
        return apiResponseResponseEntity;
    }
}
