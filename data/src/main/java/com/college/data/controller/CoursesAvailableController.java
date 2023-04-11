package com.college.data.controller;

import com.college.data.entity.ApiResponse;
import com.college.data.entity.CoursesAvailable;
import com.college.data.service.impl.CoursesAvailableServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CoursesAvailableController {
    private final CoursesAvailableServiceImpl coursesAvailableServiceImpl;
    @PostMapping("/enroll")
    public ResponseEntity<ApiResponse> enrollCourse(@RequestBody CoursesAvailable coursesAvailable) {
        return coursesAvailableServiceImpl.enrollCourse(coursesAvailable);
    }
}
