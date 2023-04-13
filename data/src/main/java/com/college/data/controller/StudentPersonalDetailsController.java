package com.college.data.controller;

import com.college.data.entity.ApiResponse;
import com.college.data.entity.StudentPersonalDetails;
import com.college.data.service.impl.StudentPersonalDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("studentPersonalDetails")
@RequiredArgsConstructor
public class StudentPersonalDetailsController {
    private final StudentPersonalDetailsServiceImpl studentPersonalDetailsServiceImpl;

    @PostMapping("/enroll")
    public ResponseEntity<ApiResponse> enrollStudentPersonalDetails(@RequestBody StudentPersonalDetails studentPersonalDetails) {
        return studentPersonalDetailsServiceImpl.enrollStudentPersonalDetails(studentPersonalDetails);
    }
    @PutMapping("/update/studentEmailId/")
    public ResponseEntity<ApiResponse> updateStudentPersonalDetails(@RequestParam String rollNo, @RequestParam String emailId) {
        return studentPersonalDetailsServiceImpl.updateStudentPersonalDetails(rollNo,emailId);
    }
}
