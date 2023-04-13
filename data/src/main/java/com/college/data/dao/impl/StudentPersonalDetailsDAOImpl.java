package com.college.data.dao.impl;

import com.college.data.dao.StudentPersonalDetailsDAO;
import com.college.data.entity.StudentPersonalDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;



@Repository
@RequiredArgsConstructor
public class StudentPersonalDetailsDAOImpl implements StudentPersonalDetailsDAO {
    private final MongoTemplate mongoTemplate;
    @Override
    public StudentPersonalDetails findStudentDetail(String rollNo) {
        Query query = new Query().addCriteria(Criteria.where("roll_no").is(rollNo));
        return mongoTemplate.findOne(query, StudentPersonalDetails.class);
    }
    @Override
    public void enrollStudentPersonalDetails(StudentPersonalDetails studentPersonalDetails) {
            mongoTemplate.save(studentPersonalDetails);
//            mongoTemplate.upsert(); //create + update - based on unique index
    }
    public void updateStudentPersonalDetails(String rollNo, String emailId) {
            Query query = new Query().addCriteria(Criteria.where("roll_no").is(rollNo));
            Update update = new Update();
            update.set("email_id",emailId);
            mongoTemplate.upsert(query,update,StudentPersonalDetails.class);
//            mongoTemplate.findAndModify(query,update, StudentPersonalDetails.class);
        //update
        //address
    }

}
