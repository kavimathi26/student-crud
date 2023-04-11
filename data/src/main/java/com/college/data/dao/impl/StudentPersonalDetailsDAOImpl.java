package com.college.data.dao.impl;

import com.college.data.dao.StudentPersonalDetailsDAO;
import com.college.data.entity.StudentPersonalDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;



@Repository
@RequiredArgsConstructor
public class StudentPersonalDetailsDAOImpl implements StudentPersonalDetailsDAO {
    private final MongoTemplate mongoTemplate;
    @Override
    public StudentPersonalDetails findStudentDetail(StudentPersonalDetails studentPersonalDetails) {
        Query query = new Query().addCriteria(Criteria.where("roll_no").is(studentPersonalDetails.getRollNo()));
        return mongoTemplate.findOne(query, StudentPersonalDetails.class);
    }
    @Override
    public void enrollStudentPersonalDetails(StudentPersonalDetails studentPersonalDetails) {
            mongoTemplate.save(studentPersonalDetails);
//            mongoTemplate.upsert(); //create + update - based on unique index
    }
    public void updateStudentPersonalDetails() {

    }
}
