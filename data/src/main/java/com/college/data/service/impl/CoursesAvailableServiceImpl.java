package com.college.data.service.impl;

import com.college.data.entity.CoursesAvailable;
import com.college.data.dao.impl.CoursesAvailableDAOImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class CoursesAvailableServiceImpl {
    private final MongoTemplate mongoTemplate;
    private final CoursesAvailableDAOImpl coursesAvailableDAOImpl;
    public void enrollCourse(CoursesAvailable coursesAvailable) {
        Query query = new Query().addCriteria(Criteria.where("course_regulation_code").is(coursesAvailable.getCourseRegulationCode()));
//        System.out.println(mongoTemplate.find(query,CoursesAvailable.class).get(0).getCourseRegulationCode());
        if(mongoTemplate.find(query,CoursesAvailable.class).get(0).getCourseRegulationCode()!=coursesAvailable.getCourseRegulationCode()) {
            coursesAvailableDAOImpl.enrollCourse(coursesAvailable);
        }
        else { //throw
            System.out.println("Course is already enrolled");
        }

    }
//    public ResponseEntity<ApiResponse> enrollCourse(CoursesAvailable coursesAvailable) {
//
//        ApiResponse apiResponse = new ApiResponse();
//        try {
//            coursesAvailableRepository.enrollCourse(coursesAvailable);
//            apiResponse.setMessage("Course Enrolled");
//            apiResponse.setErrorCode("No Error");
//            return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
//        }
//        catch (DataIntegrityViolationException e) {
//            return new ResponseEntity<>(apiResponse, HttpStatus.ALREADY_REPORTED);
//        }
//    }
}
