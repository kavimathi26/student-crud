package com.college.data.service.impl;

import com.college.data.dao.impl.StudentPersonalDetailsDAOImpl;
import com.college.data.entity.ApiResponse;
import com.college.data.entity.StudentAcademicDetails;
import com.college.data.dao.impl.StudentAcademicDetailsDAOImpl;
import com.college.data.entity.StudentPersonalDetails;
import com.college.data.service.StudentAcademicDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class StudentAcademicDetailsServiceImpl implements StudentAcademicDetailsService {
    private final StudentAcademicDetailsDAOImpl studentAcademicDetailsDAOImpl;
//    @Override
//    public void enrollStudentAcademicDetails(StudentAcademicDetails studentAcademicDetails) {
//             studentAcademicDetailsDAOImpl.enrollStudentAcademicDetails(studentAcademicDetails);
//
//    }
    ApiResponse apiResponse = new ApiResponse();
    private final StudentPersonalDetailsDAOImpl studentPersonalDetailsDAOImpl;
    public ResponseEntity<ApiResponse> enrollStudentAcademicDetails(StudentAcademicDetails studentAcademicDetails) {
        try {
            if(!(Objects.nonNull(studentAcademicDetailsDAOImpl.findStudentDetail(studentAcademicDetails)))) {
                studentAcademicDetailsDAOImpl.enrollStudentAcademicDetails(studentAcademicDetails);
                apiResponse.setMessage("Academic Details of Student Enrolled with Roll no: "+studentAcademicDetails.getRollNo());
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
