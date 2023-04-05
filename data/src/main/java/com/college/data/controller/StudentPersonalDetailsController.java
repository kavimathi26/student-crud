package com.college.data.controller;

import com.college.data.entity.FacultyDetails;
import com.college.data.entity.StudentPersonalDetails;
import com.college.data.service.StudentPersonalDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("studentPersonalDetails")
public class StudentPersonalDetailsController {
    @Autowired
    StudentPersonalDetailsService studentPersonalDetailsService;
    @PostMapping("/enroll")
    public String enrollStudentPersonalDetails(@RequestBody StudentPersonalDetails studentPersonalDetails) {
        studentPersonalDetailsService.enrollStudentPersonalDetails(studentPersonalDetails);
        return "Student Enrolled";
    }
}
