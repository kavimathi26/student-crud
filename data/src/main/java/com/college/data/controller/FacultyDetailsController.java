package com.college.data.controller;

import com.college.data.entity.CoursesAvailable;
import com.college.data.entity.FacultyDetails;
import com.college.data.service.CoursesAvailableService;
import com.college.data.service.FacultyDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/faculty")
public class FacultyDetailsController {
    @Autowired
    FacultyDetailsService facultyDetailsService;
    @PostMapping("/enroll")
    public String enrollFaculty(@RequestBody FacultyDetails facultyDetails) {
        facultyDetailsService.enrollFaculty(facultyDetails);
        return "Faculty Enrolled";
    }
}
