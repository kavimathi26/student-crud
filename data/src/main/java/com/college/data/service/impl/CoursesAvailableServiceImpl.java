package com.college.data.service.impl;

import com.college.data.entity.CoursesAvailable;
import com.college.data.repository.CoursesAvailableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class CoursesAvailableServiceImpl {
    private final CoursesAvailableRepository coursesAvailableRepository;
    public void enrollCourse(CoursesAvailable coursesAvailable) {
        Query query = new Query().addCriteria(Criteria.where("course_regulation_code").is(coursesAvailable.getCourseRegulationCode()));
        coursesAvailableRepository.enrollCourse(coursesAvailable);
    }
}
