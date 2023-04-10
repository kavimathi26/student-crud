package com.college.data.dao.impl;

import com.college.data.dao.FacultyAvailableDAO;
import com.college.data.entity.FacultyDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FacultyDetailsDAOImpl implements FacultyAvailableDAO {
    private final MongoTemplate mongoTemplate;
    @Override
    public void enrollFaculty(FacultyDetails facultyDetails) {
            mongoTemplate.save(facultyDetails);
    }
}
