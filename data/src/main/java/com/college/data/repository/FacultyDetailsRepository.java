package com.college.data.repository;

import com.college.data.entity.FacultyDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FacultyDetailsRepository {
    private final MongoTemplate mongoTemplate;
    public void enrollFaculty(FacultyDetails facultyDetails) {
            mongoTemplate.save(facultyDetails);
    }
}
