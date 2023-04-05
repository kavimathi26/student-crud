package com.college.data.repository;

import com.college.data.entity.CoursesAvailable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CoursesAvailableRepository {
    @Autowired
    MongoTemplate mongoTemplate;
    public void enrollCourse(CoursesAvailable coursesAvailable) {
        mongoTemplate.save(coursesAvailable);
    }

}
