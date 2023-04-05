package com.college.data.service;

import com.college.data.entity.CoursesAvailable;
import com.college.data.repository.CoursesAvailableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoursesAvailableService {
    @Autowired
    CoursesAvailableRepository coursesAvailableRepository;
    public void enrollCourse(CoursesAvailable coursesAvailable) {
        coursesAvailableRepository.enrollCourse(coursesAvailable);
    }
}
