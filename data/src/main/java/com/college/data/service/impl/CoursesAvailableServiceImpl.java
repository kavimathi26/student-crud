package com.college.data.service.impl;

import com.college.data.entity.ApiResponse;
import com.college.data.entity.CoursesAvailable;
import com.college.data.dao.impl.CoursesAvailableDAOImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
@RequiredArgsConstructor
public class CoursesAvailableServiceImpl {
    private final CoursesAvailableDAOImpl coursesAvailableDAOImpl;
    public ResponseEntity<ApiResponse> enrollCourse(CoursesAvailable coursesAvailable) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            if((Objects.isNull(coursesAvailableDAOImpl.findCourseAvailableDetails(coursesAvailable.getCourseRegulationCode())))) {
                coursesAvailableDAOImpl.enrollCourse(coursesAvailable);
                apiResponse.setMessage("Details of Course Enrolled with Course id: "+coursesAvailable.getCourseRegulationCode());
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

    public ResponseEntity<ApiResponse> deleteCourse(String courseRegulationCode) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            if((Objects.nonNull(coursesAvailableDAOImpl.findCourseAvailableDetails(courseRegulationCode)))) {
                coursesAvailableDAOImpl.deleteCourse(courseRegulationCode);
                apiResponse.setMessage("Details of Course Deleted with Course id: "+courseRegulationCode);
                return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
            }else {
                throw new Exception("");
            }
        }
        catch (Exception e) {
            apiResponse.setMessage(e.getMessage());
            apiResponse.setErrorCode(HttpStatus.EXPECTATION_FAILED.name());
            return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
