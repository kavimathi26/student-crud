package com.college.data.repository;

import com.college.data.entity.StudentAcademicDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentAcademicDetailsRepository {
    @Autowired
    MongoTemplate mongoTemplate;
    public void enrollStudentAcademicDetails(StudentAcademicDetails studentAcademicDetails) {
        mongoTemplate.save(studentAcademicDetails);
    }
}
