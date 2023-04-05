package com.college.data.controller;

import com.college.data.entity.StudentAcademicDetails;
import com.college.data.entity.StudentPersonalDetails;
import com.college.data.service.StudentAcademicDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/studentAcademicDetails")
@RequiredArgsConstructor
public class StudentAcademicDetailsController {
    private final StudentAcademicDetailsService studentAcademicDetailsService;

    @PostMapping("/enroll")
    public String enrollStudentAcademicDetails(@RequestBody StudentAcademicDetails studentAcademicDetails) {
        studentAcademicDetailsService.enrollStudentAcademicDetails(studentAcademicDetails);
        return "Student Enrolled";
    }
}
