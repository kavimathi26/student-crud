package com.college.data.service.impl;

import com.college.data.entity.ApiResponse;
import com.college.data.entity.FacultyDetails;
import com.college.data.dao.impl.FacultyDetailsDAOImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class FacultyDetailsServiceImpl {
    private final FacultyDetailsDAOImpl facultyDetailsDAOImpl;
    public ResponseEntity<ApiResponse> enrollFaculty(FacultyDetails facultyDetails) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            if((Objects.isNull(facultyDetailsDAOImpl.findFacultyDetail(facultyDetails.getFacultyId())))) {
                facultyDetailsDAOImpl.enrollFaculty(facultyDetails);
                apiResponse.setMessage("Details of Faculty Enrolled with Faculty id: "+facultyDetails.getFacultyId());
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
    public FacultyDetails getFacultyDetails(String facultyId) {
        return facultyDetailsDAOImpl.findFacultyDetail(facultyId);
    }

    public List<FacultyDetails> getFacultyDetailsForAGivenRollNo(String rollNo) {
        return facultyDetailsDAOImpl.getFacultyDetailsForAGivenRollNo(rollNo);
    }
    public List<FacultyDetails> getFacultyDetailsForAGivenCourseCode(String courseCode) {
        return facultyDetailsDAOImpl.getFacultyDetailsForAGivenCourseCode(courseCode);
    }
}
