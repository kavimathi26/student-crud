package com.college.data.repository;

import com.college.data.entity.StudentPersonalDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class StudentPersonalDetailsRepository {
    private final MongoTemplate mongoTemplate;
    public void enrollStudentPersonalDetails(StudentPersonalDetails studentPersonalDetails) {
        mongoTemplate.save(studentPersonalDetails);
    }
}
