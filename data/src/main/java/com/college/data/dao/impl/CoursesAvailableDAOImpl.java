package com.college.data.dao.impl;

import com.college.data.dao.CoursesAvailableDAO;
import com.college.data.dao.StudentAcademicDetailsDAO;
import com.college.data.entity.CourseEnrolledByStudent;
import com.college.data.entity.CoursesAvailable;
import com.college.data.entity.FacultyDetails;
import com.college.data.entity.StudentAcademicDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CoursesAvailableDAOImpl implements CoursesAvailableDAO {
    private final MongoTemplate mongoTemplate;
    private final StudentAcademicDetailsDAO studentAcademicDetailsDAO;
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
    public List<CoursesAvailable> getCourseDetailsWithRollNo(String rollNo) {
        Query query = new Query();
        query.addCriteria(Criteria.where("roll_no").is(rollNo));
        query.fields().include("list_of_courses_enrolled.course_code");
        StudentAcademicDetails details = studentAcademicDetailsDAO.findStudentDetail(rollNo);
        List<String> courseCodes = details.getListOfCoursesEnrolled().stream().map(CourseEnrolledByStudent::getCourseCode).collect(Collectors.toList());
        System.out.println(courseCodes);
        List<CoursesAvailable> courses = new ArrayList<>();
        for (String courseCode : courseCodes) {
            for (CoursesAvailable coursesAvailable : mongoTemplate.findAll(CoursesAvailable.class)) {
                if (coursesAvailable.getCourseRegulationCode().contains(courseCode)) {
                    courses.add(coursesAvailable);
                }
            }
        }
        return courses;
    }
}
