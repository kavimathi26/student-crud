package com.college.data.dao.impl;

import com.college.data.dao.StudentPersonalDetailsDAO;
import com.college.data.entity.StudentPersonalDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class StudentPersonalDetailsDAOImpl implements StudentPersonalDetailsDAO {
    private final MongoTemplate mongoTemplate;
    @Override
    public void enrollStudentPersonalDetails(StudentPersonalDetails studentPersonalDetails) {
        mongoTemplate.save(studentPersonalDetails);
    }
}
