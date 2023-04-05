package com.college.data.controller;

import com.college.data.entity.ApiResponse;
import com.college.data.entity.StudentPersonalDetails;
import com.college.data.service.impl.StudentPersonalDetailsServiceImpl;
import com.college.data.service.impl.StudentPersonalDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("studentPersonalDetails")
public class StudentPersonalDetailsController {
    @Autowired
    StudentPersonalDetailsServiceImpl studentPersonalDetailsServiceImpl;

    //    @PostMapping("/enroll")
//    public String enrollStudentPersonalDetails(@RequestBody StudentPersonalDetails studentPersonalDetails) {
//        studentPersonalDetailsService.enrollStudentPersonalDetails(studentPersonalDetails);
//        return "Student Enrolled";
//    }
    @PostMapping("/enroll")
    public ResponseEntity<ApiResponse> enrollStudentPersonalDetails(@RequestBody StudentPersonalDetails studentPersonalDetails) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            studentPersonalDetailsServiceImpl.enrollStudentPersonalDetails(studentPersonalDetails);
            apiResponse.setMessage("Personal Details of Student Enrolled");
            apiResponse.setErrorCode("No Error");
            return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            apiResponse.setMessage(e.getMessage());
            apiResponse.setMessage(HttpStatus.ALREADY_REPORTED.name());
            return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            apiResponse.setMessage(e.getMessage());
            apiResponse.setErrorCode(HttpStatus.EXPECTATION_FAILED.name());
            return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
