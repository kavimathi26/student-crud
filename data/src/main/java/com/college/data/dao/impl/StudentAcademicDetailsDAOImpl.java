package com.college.data.dao.impl;

import com.college.data.dao.StudentAcademicDetailsDAO;
import com.college.data.entity.StudentAcademicDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StudentAcademicDetailsDAOImpl implements StudentAcademicDetailsDAO {
    private final MongoTemplate mongoTemplate;
    @Override
    public StudentAcademicDetails findStudentDetail(String rollNo){
        Query query = new Query().addCriteria(Criteria.where("roll_no").is(rollNo));
        return mongoTemplate.findOne(query, StudentAcademicDetails.class);
    }
    @Override
    public void enrollStudentAcademicDetails(StudentAcademicDetails studentAcademicDetails) {
        mongoTemplate.save(studentAcademicDetails);
    }
}
