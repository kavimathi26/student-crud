package com.college.data.dao;

import com.college.data.entity.CoursesAvailable;

public interface CoursesAvailableDAO {
    String COURSE = "courses_available";
    void enrollCourse(CoursesAvailable coursesAvailable);
}
