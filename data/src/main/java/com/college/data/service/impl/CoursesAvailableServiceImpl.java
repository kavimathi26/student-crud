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
    ApiResponse apiResponse = new ApiResponse();
    private final CoursesAvailableDAOImpl coursesAvailableDAOImpl;
    public ResponseEntity<ApiResponse> enrollCourse(CoursesAvailable coursesAvailable) {
        try {
            if(!(Objects.nonNull(coursesAvailableDAOImpl.findCourseAvailableDetails(coursesAvailable)))) {
                coursesAvailableDAOImpl.enrollCourse(coursesAvailable);
                apiResponse.setMessage("Details of Course Enrolled with Faculty id: "+coursesAvailable.getCourseRegulationCode());
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
