package com.college.data.controller;

import com.college.data.entity.ApiResponse;
import com.college.data.entity.FacultyDetails;
import com.college.data.service.impl.FacultyDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
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
        ApiResponse apiResponse = new ApiResponse();
        try {
            facultyDetailsServiceImpl.enrollFaculty(facultyDetails);
            apiResponse.setMessage("Faculty Details Enrolled");
            apiResponse.setErrorCode("No Error");
            return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
        }catch (DataIntegrityViolationException e){
            apiResponse.setMessage(HttpStatus.ALREADY_REPORTED.name());
            return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            apiResponse.setMessage(e.getMessage());
            apiResponse.setErrorCode(HttpStatus.EXPECTATION_FAILED.name());
            return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
