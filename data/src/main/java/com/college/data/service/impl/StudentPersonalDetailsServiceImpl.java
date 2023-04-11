package com.college.data.service.impl;

import com.college.data.entity.ApiResponse;
import com.college.data.entity.StudentPersonalDetails;
import com.college.data.dao.impl.StudentPersonalDetailsDAOImpl;
import com.college.data.service.StudentPersonalDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class StudentPersonalDetailsServiceImpl implements StudentPersonalDetailsService {
    ApiResponse apiResponse = new ApiResponse();
    private final StudentPersonalDetailsDAOImpl studentPersonalDetailsDAOImpl;
    public ResponseEntity<ApiResponse> enrollStudentPersonalDetails(StudentPersonalDetails studentPersonalDetails) {
        try {
            if(!(Objects.nonNull(studentPersonalDetailsDAOImpl.findStudentDetail(studentPersonalDetails)))) {
                studentPersonalDetailsDAOImpl.enrollStudentPersonalDetails(studentPersonalDetails);
                apiResponse.setMessage("Personal Details of Student Enrolled with Roll no: "+studentPersonalDetails.getRollNo());
                return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
            }else {
                throw new DataIntegrityViolationException("");
            }
        } catch (DataIntegrityViolationException e) {
            apiResponse.setMessage("Duplicate Entry. This detail is already Enrolled.");
            return new ResponseEntity<>(apiResponse, HttpStatus.CONFLICT);
        }
        catch (Exception e) {
            apiResponse.setMessage(e.getMessage());
            apiResponse.setErrorCode(HttpStatus.EXPECTATION_FAILED.name());
            return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}