package com.college.data.dao.impl;

import com.college.data.dao.CoursesAvailableDAO;
import com.college.data.entity.CoursesAvailable;
import com.college.data.entity.FacultyDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CoursesAvailableDAOImpl implements CoursesAvailableDAO {
    private final MongoTemplate mongoTemplate;
    @Override
    public CoursesAvailable findCourseAvailableDetails(CoursesAvailable coursesAvailable) {
        Query query = new Query().addCriteria(Criteria.where("roll_no").is(coursesAvailable.getCourseRegulationCode()));
        return mongoTemplate.findOne(query, CoursesAvailable.class);
    }
    @Override
    public void enrollCourse(CoursesAvailable coursesAvailable) {
        mongoTemplate.save(coursesAvailable);
    }

}
