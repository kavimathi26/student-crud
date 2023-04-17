package com.college.data.dao.impl;

import com.college.data.entity.StudentAcademicDetails;
import com.college.data.entity.StudentCompleteDetails;
import com.college.data.entity.StudentPersonalDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    @RequiredArgsConstructor
    public class StudentCompleteDetailsDAOImpl {
        private final MongoTemplate mongoTemplate;

        public List<StudentCompleteDetails> viewDetailsOfAParticularStudent(String rollNo) {
            Query query = new Query().addCriteria(Criteria.where("roll_no").is(rollNo));
            System.out.println(mongoTemplate.find(query,StudentCompleteDetails.class));
           return mongoTemplate.find(query,StudentCompleteDetails.class);
        }
    }