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
    public CoursesAvailable findCourseAvailableDetails(String courseRegulationCode) {
        Query query = new Query().addCriteria(Criteria.where("course_regulation_code").is(courseRegulationCode));
        return mongoTemplate.findOne(query, CoursesAvailable.class);
    }
    @Override
    public void enrollCourse(CoursesAvailable coursesAvailable) {
        mongoTemplate.save(coursesAvailable);
    }

    public void deleteCourse(String courseRegulationCode) {
        Query query = new Query().addCriteria(Criteria.where("course_regulation_code").is(courseRegulationCode));
        mongoTemplate.remove(Query.query(Criteria.where("course_regulation_code").is(courseRegulationCode)), CoursesAvailable.class);
    }
}
