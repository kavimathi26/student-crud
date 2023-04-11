package com.college.data.dao.impl;

import com.college.data.dao.FacultyAvailableDAO;
import com.college.data.entity.FacultyDetails;
import com.college.data.entity.StudentPersonalDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FacultyDetailsDAOImpl implements FacultyAvailableDAO {
    private final MongoTemplate mongoTemplate;
    @Override
    public FacultyDetails findFacultyDetail(FacultyDetails facultyDetails) {
        Query query = new Query().addCriteria(Criteria.where("roll_no").is(facultyDetails.getFacultyId()));
        return mongoTemplate.findOne(query, FacultyDetails.class);
    }
    @Override
    public void enrollFaculty(FacultyDetails facultyDetails) {
            mongoTemplate.save(facultyDetails);
    }
}
