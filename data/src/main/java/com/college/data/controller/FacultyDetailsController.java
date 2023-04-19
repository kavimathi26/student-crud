package com.college.data.controller;

import com.college.data.entity.ApiResponse;
import com.college.data.entity.FacultyDetails;
import com.college.data.service.impl.FacultyDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculty")
@RequiredArgsConstructor
public class FacultyDetailsController {
    private final FacultyDetailsServiceImpl facultyDetailsServiceImpl;
    @PostMapping("/enroll")
    public ResponseEntity<ApiResponse> enrollFaculty(@RequestBody FacultyDetails facultyDetails) {
        return facultyDetailsServiceImpl.enrollFaculty(facultyDetails);
    }
    @GetMapping("/roll-no/{RollNo}")
    public List<FacultyDetails> getFacultyDetailsForAGivenRollNo(@PathVariable String RollNo) {
        return facultyDetailsServiceImpl.getFacultyDetailsForAGivenRollNo(RollNo);
    }
    @GetMapping("/course-code/{courseCode}")
    public List<FacultyDetails> getFacultyDetailsForAGivenCourseCode(@PathVariable String courseCode) {
        return facultyDetailsServiceImpl.getFacultyDetailsForAGivenCourseCode(courseCode);
    }
}
