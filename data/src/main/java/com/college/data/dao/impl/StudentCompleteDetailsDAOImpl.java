//package com.college.data.dao.impl;
//
//import com.college.data.entity.*;
//import com.college.data.service.impl.StudentCompleteDetailsServiceImpl;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Repository
//    @RequiredArgsConstructor
//    public class StudentCompleteDetailsDAOImpl {
//        private final MongoTemplate mongoTemplate;
//        private final StudentCompleteDetailsServiceImpl studentCompleteDetailsServiceImpl;
//        private final StudentAcademicDetailsDAOImpl studentAcademicDetailsDAO;
//        public List<Object> viewDetailsOfAParticularStudent(String rollNo) {
//            List<Object> entireDetails = new ArrayList<>();
//            Query query = new Query().addCriteria(Criteria.where("roll_no").is(rollNo));
//            List<StudentPersonalDetails> studentPersonalDetails= studentCompleteDetailsServiceImpl.getStudentPersonalDetails(rollNo);
//            List<StudentAcademicDetails> studentAcademicDetails = studentCompleteDetailsServiceImpl.getStudentAcademicDetails(rollNo);
//            entireDetails.addAll(studentPersonalDetails);
//            entireDetails.addAll(studentAcademicDetails);
//
//            Query query2 = new Query();
//            query2.addCriteria(Criteria.where("roll_no").is(rollNo));
//            query2.fields().include("list_of_courses_enrolled.course_code");
//            StudentAcademicDetails details = mongoTemplate.findOne(query, StudentAcademicDetails.class);
//            List<String> courseCodes = details.getListOfCoursesEnrolled().stream().map(CourseEnrolledByStudent::getCourseCode).collect(Collectors.toList());
//            System.out.println(courseCodes);
//
//            List<String> facultyIds = new ArrayList<>();
//            for (String courseCode : courseCodes) {
//                for (FacultyDetails facultyDetails : mongoTemplate.findAll(FacultyDetails.class)) {
//                    if (facultyDetails.getCoursesHandled().contains(courseCode)) {
//                        facultyIds.add(facultyDetails.getFacultyId());
//                    }
//                }
//            }
//            System.out.println(facultyIds);
//            entireDetails.addAll(facultyIds);
//            return entireDetails;
//        }
//    }