package com.college.data.dao.impl;

import com.college.data.constant.StatusChange;
import com.college.data.dao.StudentPersonalDetailsDAO;
import com.college.data.entity.StudentPersonalDetails;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
@RequiredArgsConstructor
public class StudentPersonalDetailsDAOImpl extends StatusChange implements StudentPersonalDetailsDAO {
    private final MongoTemplate mongoTemplate;
    @Override
    public StudentPersonalDetails findStudentDetail(String rollNo) {
        Query query = new Query().addCriteria(Criteria.where("roll_no").is(rollNo));
        return mongoTemplate.findOne(query, StudentPersonalDetails.class);
    }
    @Override
    public void enrollStudentPersonalDetails(StudentPersonalDetails studentPersonalDetails) {
            mongoTemplate.save(studentPersonalDetails);
    }
    public void updateStudentPersonalDetails(String rollNo, String emailId) {
            Query query = new Query().addCriteria(Criteria.where("roll_no").is(rollNo));
            Update update = new Update();
            update.set("email_id",emailId);
            update.set("updated_at",new Date());
            mongoTemplate.findAndModify(query,update, StudentPersonalDetails.class);
    }

    public void updateEntireDetailsOfAParticularStudent(StudentPersonalDetails studentPersonalDetails) {
        Query query = new Query().addCriteria(Criteria.where("roll_no").is(studentPersonalDetails.getRollNo()));
        Update update = Update.fromDocument(new Document("$set", studentPersonalDetails));
        mongoTemplate.upsert(query,update,StudentPersonalDetails.class);
    }

    public void updateStatus(String rollNo) {
        Query query = new Query().addCriteria(Criteria.where("roll_no").is(rollNo));
        Update update = new Update();
        update.set("status", StatusChange.INACTIVE);
        update.set("updated_at",new Date());
        mongoTemplate.findAndModify(query,update, StudentPersonalDetails.class);
    }
}
