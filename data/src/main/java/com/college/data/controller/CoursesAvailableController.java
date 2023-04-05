package com.college.data.controller;

import com.college.data.entity.CoursesAvailable;
import com.college.data.service.CoursesAvailableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController("/courses")
//@RequestMapping("/courses",)
public class CoursesAvailableController {
    @Autowired
    CoursesAvailableService coursesAvailableService;
    @PostMapping("/enroll")
    public String enrollCourse(@RequestBody CoursesAvailable coursesAvailable) {
        coursesAvailableService.enrollCourse(coursesAvailable);
        return "Course Enrolled";
    }
}
