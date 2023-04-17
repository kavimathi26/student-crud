package com.college.data.dao;

import com.college.data.entity.CoursesAvailable;
import com.college.data.entity.FacultyDetails;

public interface CoursesAvailableDAO {
    String COURSE = "courses_available";
    CoursesAvailable findCourseAvailableDetails(String courseRegulationCode);
    void enrollCourse(CoursesAvailable coursesAvailable);
}
