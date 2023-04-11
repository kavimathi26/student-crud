package com.college.data.dao.impl;

import com.college.data.dao.StudentPersonalDetailsDAO;
import com.college.data.entity.ApiResponse;
import com.college.data.entity.StudentPersonalDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class StudentPersonalDetailsDAOImpl implements StudentPersonalDetailsDAO {
    private final MongoTemplate mongoTemplate;
    @Override
//    public ResponseEntity<ApiResponse> enrollStudentPersonalDetails(StudentPersonalDetails studentPersonalDetails) {
//        ApiResponse apiResponse = new ApiResponse();
//        try {
//            Query query = new Query().addCriteria(Criteria.where("roll_no").is(studentPersonalDetails.getRollNo()));
//            mongoTemplate.findOne(query, StudentPersonalDetails.class);
////            System.out.println("hi " + query);
////            System.out.println("hello " + mongoTemplate.findOne(query, StudentPersonalDetails.class));
//            if ((mongoTemplate.findOne(query, StudentPersonalDetails.class)) != null) {
//                System.out.println("Data Already Enrolled");
//                throw new DataIntegrityViolationException("Data Already Enrolled Exception");
//            } else {
//                System.out.println("Data enrolled");
//                mongoTemplate.save(studentPersonalDetails);
//
//            }
//        }
//        catch (Exception e) {
//
//        }
//        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
//    }
    public void enrollStudentPersonalDetails(StudentPersonalDetails studentPersonalDetails) {
            Query query = new Query().addCriteria(Criteria.where("roll_no").is(studentPersonalDetails.getRollNo()));
            mongoTemplate.findOne(query, StudentPersonalDetails.class);
            mongoTemplate.save(studentPersonalDetails);

//            System.out.println("hi " + query);
//            System.out.println("hello " + mongoTemplate.findOne(query, StudentPersonalDetails.class));
//            if ((mongoTemplate.findOne(query, StudentPersonalDetails.class)) != null) {
//                mongoTemplate.save(studentPersonalDetails);
//            }
    }
}
