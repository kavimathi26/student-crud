package com.college.data.controller;

import com.college.data.entity.ApiResponse;
import com.college.data.entity.StudentPersonalDetails;
import com.college.data.service.impl.StudentPersonalDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("studentPersonalDetails")
@RequiredArgsConstructor
public class StudentPersonalDetailsController {
    private final StudentPersonalDetailsServiceImpl studentPersonalDetailsServiceImpl;

    @PostMapping("/enroll")

    public ResponseEntity<ApiResponse> enrollStudentPersonalDetails(@Valid @RequestBody StudentPersonalDetails studentPersonalDetails) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            if(studentPersonalDetailsServiceImpl.enrollStudentPersonalDetails(studentPersonalDetails)==true) {
                apiResponse.setMessage("Personal Details of Student Enrolled");
                apiResponse.setErrorCode("No Error");
                return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
            }
            else {
                throw new DataIntegrityViolationException("Data Already Reported");
            }
        } catch (DataIntegrityViolationException e) {
            apiResponse.setMessage("Duplicate Entry. This detail is already Enrolled.");
            return new ResponseEntity<>(apiResponse, HttpStatus.CONFLICT);
        } catch (Exception e) {
            apiResponse.setMessage(e.getMessage());
            apiResponse.setErrorCode(HttpStatus.EXPECTATION_FAILED.name());
            return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
