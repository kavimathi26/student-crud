package com.college.data.repository;

import com.college.data.entity.FacultyDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FacultyDetailsRepository {
    @Autowired
    MongoTemplate mongoTemplate;
    public void enrollFaculty(FacultyDetails facultyDetails) {
        mongoTemplate.save(facultyDetails);
    }
}
