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

import java.util.Date;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class StudentPersonalDetailsServiceImpl implements StudentPersonalDetailsService {
    ApiResponse apiResponse = new ApiResponse();
    private final StudentPersonalDetailsDAOImpl studentPersonalDetailsDAOImpl;
    public ResponseEntity<ApiResponse> enrollStudentPersonalDetails(StudentPersonalDetails studentPersonalDetails) {
        try {
            if(Objects.isNull(studentPersonalDetailsDAOImpl.findStudentDetail(studentPersonalDetails.getRollNo()))) {
                studentPersonalDetails.setCreatedAt(new Date());
                studentPersonalDetails.setStatus("ACTIVE");
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

    public ResponseEntity<ApiResponse> updateStudentPersonalDetails(String rollNo, String emailId) {
        try {
            if((Objects.nonNull(studentPersonalDetailsDAOImpl.findStudentDetail(rollNo)))) {
                studentPersonalDetailsDAOImpl.updateStudentPersonalDetails(rollNo, emailId);
                apiResponse.setMessage("email Id of "+rollNo+" is updated");
                return new ResponseEntity<>(apiResponse,HttpStatus.OK);
            }else {
                throw new NoSuchFieldException("No such data found");
            }
        }
        catch (NoSuchFieldException e) {
            apiResponse.setMessage(e.getMessage());
            return new ResponseEntity<>(apiResponse,HttpStatus.NO_CONTENT);
        }
        catch (Exception e) {
            apiResponse.setMessage(e.getMessage());
            return new ResponseEntity<>(apiResponse,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<ApiResponse> updateEntireDetailsOfAParticularStudent(StudentPersonalDetails studentPersonalDetails) {
        try {
            studentPersonalDetailsDAOImpl.updateEntireDetailsOfAParticularStudent(studentPersonalDetails);
            apiResponse.setMessage("Details updated for "+studentPersonalDetails.getRollNo());
            return new ResponseEntity<>(apiResponse,HttpStatus.OK);
        }
        catch (Exception e) {
            apiResponse.setMessage(e.getMessage());
            return new ResponseEntity<>(apiResponse,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<ApiResponse> updateStatus(String rollNo, String status) {
        try {
            if((Objects.nonNull(studentPersonalDetailsDAOImpl.findStudentDetail(rollNo)))) {
                studentPersonalDetailsDAOImpl.updateStatus(rollNo, status);
                apiResponse.setMessage("status for "+rollNo+" is updated");
                return new ResponseEntity<>(apiResponse,HttpStatus.OK);
            }else {
                throw new NoSuchFieldException("No such data found");
            }
        }
        catch (NoSuchFieldException e) {
            apiResponse.setMessage(e.getMessage());
            return new ResponseEntity<>(apiResponse,HttpStatus.NO_CONTENT);
        }
        catch (Exception e) {
            apiResponse.setMessage(e.getMessage());
            return new ResponseEntity<>(apiResponse,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}