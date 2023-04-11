package com.college.data.controller;

import com.college.data.entity.ApiResponse;
import com.college.data.entity.FacultyDetails;
import com.college.data.service.impl.FacultyDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/faculty")
@RequiredArgsConstructor
public class FacultyDetailsController {
    private final FacultyDetailsServiceImpl facultyDetailsServiceImpl;
    @PostMapping("/enroll")
    public ResponseEntity<ApiResponse> enrollFaculty(@RequestBody FacultyDetails facultyDetails) {
        return facultyDetailsServiceImpl.enrollFaculty(facultyDetails);
    }
}
