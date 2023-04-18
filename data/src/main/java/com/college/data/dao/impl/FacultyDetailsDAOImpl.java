package com.college.data.dao.impl;

import com.college.data.dao.FacultyAvailableDAO;
import com.college.data.entity.CourseEnrolledByStudent;
import com.college.data.entity.FacultyDetails;
import com.college.data.entity.StudentPersonalDetails;
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
public class FacultyDetailsDAOImpl implements FacultyAvailableDAO {
    private final MongoTemplate mongoTemplate;
    private final CoursesAvailableDAOImpl coursesAvailableDAO;
    private final StudentAcademicDetailsDAOImpl studentAcademicDetailsDAO;
    @Override
    public FacultyDetails findFacultyDetail(String facultyId) {
        Query query = new Query().addCriteria(Criteria.where("faculty_id").is(facultyId));
        return mongoTemplate.findOne(query, FacultyDetails.class);
    }
    @Override
    public void enrollFaculty(FacultyDetails facultyDetails) {
            mongoTemplate.save(facultyDetails);
    }
    public List<FacultyDetails> getFacultyDetailsForAGivenRollNo(String RollNo) {
        List<String> courseCodes = studentAcademicDetailsDAO.findStudentDetail(RollNo).getListOfCoursesEnrolled().stream().map(CourseEnrolledByStudent::getCourseCode).collect(Collectors.toList());
        List<FacultyDetails> facultyDetailsForAparticularCourse = new ArrayList<>();
        for (String courseCode : courseCodes) {
            for (FacultyDetails facultyDetails : mongoTemplate.findAll(FacultyDetails.class)) {
                if (facultyDetails.getCoursesHandled().contains(courseCode)) {
                    facultyDetailsForAparticularCourse.add(facultyDetails);
                }
            }
        }
        return facultyDetailsForAparticularCourse;
    }
}
