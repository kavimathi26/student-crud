package com.college.data.controller;

import com.college.data.entity.ApiResponse;
import com.college.data.entity.CoursesAvailable;
import com.college.data.service.impl.CoursesAvailableServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/courses")
public class CoursesAvailableController {
    @Autowired
    CoursesAvailableServiceImpl coursesAvailableServiceImpl;
    @PostMapping("/enroll")
    public ResponseEntity<ApiResponse> enrollCourse(@RequestBody CoursesAvailable coursesAvailable) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            coursesAvailableServiceImpl.enrollCourse(coursesAvailable);
            apiResponse.setMessage("Course Enrolled");
            apiResponse.setErrorCode("No Error");
            return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);        }
        catch (DataIntegrityViolationException e) {
            apiResponse.setMessage(e.getMessage());
            apiResponse.setMessage(HttpStatus.ALREADY_REPORTED.name());
            return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            return new ResponseEntity<>(apiResponse,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
