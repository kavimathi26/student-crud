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
    public boolean checkForDuplicates(StudentPersonalDetails studentPersonalDetails) {
        Query query = new Query().addCriteria(Criteria.where("roll_no").is(studentPersonalDetails.getRollNo()));
        if ((mongoTemplate.findOne(query, StudentPersonalDetails.class)) != null) {
                return false;
            }
        return true;
    }
    @Override
    public void enrollStudentPersonalDetails(StudentPersonalDetails studentPersonalDetails) {
            Query query = new Query().addCriteria(Criteria.where("roll_no").is(studentPersonalDetails.getRollNo()));
            mongoTemplate.findOne(query, StudentPersonalDetails.class);
            mongoTemplate.save(studentPersonalDetails);
    }
}
