package com.college.data.dao.impl;

import com.college.data.dao.CoursesAvailableDAO;
import com.college.data.entity.CoursesAvailable;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CoursesAvailableDAOImpl implements CoursesAvailableDAO {
    private final MongoTemplate mongoTemplate;
    @Override
    public void enrollCourse(CoursesAvailable coursesAvailable) {
        mongoTemplate.save(coursesAvailable);
    }

}
