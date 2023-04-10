package com.college.data.dao.impl;

import com.college.data.dao.StudentAcademicDetailsDAO;
import com.college.data.entity.StudentAcademicDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class StudentAcademicDetailsDAOImpl implements StudentAcademicDetailsDAO {
    private final MongoTemplate mongoTemplate;
    public void enrollStudentAcademicDetails(StudentAcademicDetails studentAcademicDetails) {
        mongoTemplate.save(studentAcademicDetails);
    }
}
