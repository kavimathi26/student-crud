package com.college.data.controller;

import com.college.data.entity.ApiResponse;
import com.college.data.entity.StudentPersonalDetails;
import com.college.data.service.impl.StudentPersonalDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/studentPersonalDetails")
@RequiredArgsConstructor
public class StudentPersonalDetailsController {
    private final StudentPersonalDetailsServiceImpl studentPersonalDetailsServiceImpl;

    @PostMapping("/enroll")
    public ResponseEntity<ApiResponse> enrollStudentPersonalDetails(@RequestBody StudentPersonalDetails studentPersonalDetails) {
            ApiResponse apiResponse = studentPersonalDetailsServiceImpl.enrollStudentPersonalDetails(studentPersonalDetails);
        if (apiResponse.getSuccess()==true) {
            return new ResponseEntity<>(apiResponse,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(apiResponse,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/update/studentEmailId/")
    public ResponseEntity<ApiResponse> updateStudentPersonalDetails(@RequestParam String rollNo, @RequestParam String emailId) {
        ApiResponse apiResponse = studentPersonalDetailsServiceImpl.updateStudentPersonalDetails(rollNo,emailId);
        if (apiResponse.getSuccess()) {
            return new ResponseEntity<>(apiResponse,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(apiResponse,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/update/studentDetails")
    public ResponseEntity<ApiResponse> updateEntireDetailsOfAParticularStudent(@RequestBody StudentPersonalDetails studentPersonalDetails) {
        ApiResponse apiResponse = studentPersonalDetailsServiceImpl.updateEntireDetailsOfAParticularStudent(studentPersonalDetails);
        if (apiResponse.getSuccess()) {
            return new ResponseEntity<>(apiResponse,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(apiResponse,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/update/status/")
    private ResponseEntity<ApiResponse> updateStatus(@RequestParam String rollNo) {
        ApiResponse apiResponse = studentPersonalDetailsServiceImpl.updateStatus(rollNo);
        if (apiResponse.getSuccess()) {
            return new ResponseEntity<>(apiResponse,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(apiResponse,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
