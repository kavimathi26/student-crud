package com.college.data.repository;

import com.college.data.entity.StudentPersonalDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentPersonalDetailsRepository {
    @Autowired
    MongoTemplate mongoTemplate;
    public void enrollStudentPersonalDetails(StudentPersonalDetails studentPersonalDetails) {
        mongoTemplate.save(studentPersonalDetails);
    }
}
