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
        ApiResponse apiResponse = new ApiResponse();
        try {
            studentAcademicDetailsServiceImpl.enrollStudentAcademicDetails(studentAcademicDetails);
            apiResponse.setMessage("Academic Details of Student Enrolled");
            apiResponse.setErrorCode("No Error");
            return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
        }
        catch (DataIntegrityViolationException e) {
            apiResponse.setMessage(HttpStatus.ALREADY_REPORTED.name());
            return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            apiResponse.setMessage(e.getMessage());
            apiResponse.setErrorCode(HttpStatus.EXPECTATION_FAILED.name());
            return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
