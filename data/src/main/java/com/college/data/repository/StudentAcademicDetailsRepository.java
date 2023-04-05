package com.college.data.repository;

import com.college.data.entity.StudentAcademicDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class StudentAcademicDetailsRepository {
    private final MongoTemplate mongoTemplate;
    public void enrollStudentAcademicDetails(StudentAcademicDetails studentAcademicDetails) {
        mongoTemplate.save(studentAcademicDetails);
    }
}
