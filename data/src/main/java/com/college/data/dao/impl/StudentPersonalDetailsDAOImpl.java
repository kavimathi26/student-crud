package com.college.data.dao.impl;

import com.college.data.dao.StudentPersonalDetailsDAO;
import com.college.data.entity.StudentPersonalDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;


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
    }
    public void updateStudentPersonalDetails(String rollNo, String emailId) {
            Query query = new Query().addCriteria(Criteria.where("roll_no").is(rollNo));
            Update update = new Update();
            update.set("email_id",emailId);
            mongoTemplate.findAndModify(query,update, StudentPersonalDetails.class);
    }

    public void updateEntireDetailsOfAParticularStudent(StudentPersonalDetails studentPersonalDetails) {
        Query query = new Query().addCriteria(Criteria.where("roll_no").is(studentPersonalDetails.getRollNo()));
        Update update = new Update();
        update.set("email_id",studentPersonalDetails.getEmailId());
        update.set("phone_number",studentPersonalDetails.getPhoneNumber());
        update.set("address.door_number",studentPersonalDetails.getAddress().getDoorNumber());
        update.set("address.street_name",studentPersonalDetails.getAddress().getStreetName());
        update.set("address.city_name",studentPersonalDetails.getAddress().getCityName());
        update.set("address.district",studentPersonalDetails.getAddress().getDistrict());
        update.set("address.pin_code",studentPersonalDetails.getAddress().getPinCode());
        update.set("updated_at",new Date());
        mongoTemplate.upsert(query,update,StudentPersonalDetails.class);
    }

    public void updateStatus(String rollNo, String status) {
        Query query = new Query().addCriteria(Criteria.where("roll_no").is(rollNo));
        Update update = new Update();
        update.set("status",status);
        mongoTemplate.findAndModify(query,update, StudentPersonalDetails.class);
    }
}
