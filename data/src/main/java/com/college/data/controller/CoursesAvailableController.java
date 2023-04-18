package com.college.data.controller;

import com.college.data.entity.ApiResponse;
import com.college.data.entity.CoursesAvailable;
import com.college.data.service.impl.CoursesAvailableServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CoursesAvailableController {
    private final CoursesAvailableServiceImpl coursesAvailableServiceImpl;
    @PostMapping("/enroll")
    public ResponseEntity<ApiResponse> enrollCourse(@RequestBody CoursesAvailable coursesAvailable) {
        return coursesAvailableServiceImpl.enrollCourse(coursesAvailable);
    }

    @DeleteMapping("/delete/")
    public ResponseEntity<ApiResponse>  deleteCourse(@RequestParam String courseRegulationCode) {
        return coursesAvailableServiceImpl.deleteCourse(courseRegulationCode);
    }
    @GetMapping("/{rollNo}")
    public List<CoursesAvailable> getCourseDetailsForAParticularRollNo(@PathVariable String rollNo) {
        return coursesAvailableServiceImpl.getCourseDetailsForAParticularRollNo(rollNo);
    }
}
