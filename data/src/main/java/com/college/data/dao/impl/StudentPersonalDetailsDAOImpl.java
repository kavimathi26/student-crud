package com.college.data.dao.impl;

import com.college.data.constant.StatusChange;
import com.college.data.dao.StudentPersonalDetailsDAO;
import com.college.data.entity.*;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
@RequiredArgsConstructor
public class StudentPersonalDetailsDAOImpl extends StatusChange implements StudentPersonalDetailsDAO {
    private final MongoTemplate mongoTemplate;
    @Override
    public StudentPersonalDetails findStudentDetail(String rollNo) {
        Query query = new Query().addCriteria(Criteria.where("roll_no").is(rollNo));
        return mongoTemplate.findOne(query, StudentPersonalDetails.class);
    }
    @Override
    public void enrollStudentPersonalDetails(StudentPersonalDetails studentPersonalDetails) {
            mongoTemplate.save(studentPersonalDetails);
    }
    public void updateStudentPersonalDetails(String rollNo, String emailId) {
            Query query = new Query().addCriteria(Criteria.where("roll_no").is(rollNo));
            Update update = new Update();
            update.set("email_id",emailId);
            update.set("updated_at",new Date());
            mongoTemplate.findAndModify(query,update, StudentPersonalDetails.class);
    }

    public void updateEntireDetailsOfAParticularStudent(StudentPersonalDetails studentPersonalDetails) {
        Query query = new Query().addCriteria(Criteria.where("roll_no").is(studentPersonalDetails.getRollNo()));
        Update update = Update.fromDocument(new Document("$set", studentPersonalDetails));
        mongoTemplate.upsert(query,update,StudentPersonalDetails.class);
    }

    public void updateStatus(String rollNo) {
        Query query = new Query().addCriteria(Criteria.where("roll_no").is(rollNo));
        Update update = new Update();
        update.set("status", StatusChange.INACTIVE);
        update.set("updated_at",new Date());
        mongoTemplate.findAndModify(query,update, StudentPersonalDetails.class);
    }

    public List<StudentCompleteDetails> viewStudentDetailsUsingAggregate(String rollNo) {
        Aggregation agg = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("roll_no").is(rollNo)),
                Aggregation.lookup("student_personal_details", "roll_no", "roll_no", "personal_details"),
                Aggregation.unwind("personal_details"),
                Aggregation.lookup("student_academic_details", "roll_no", "roll_no", "academic_details"),
                Aggregation.unwind("academic_details"),
                Aggregation.lookup("courses_available", "academic_details.list_of_courses_enrolled.course_code", "course_regulation_code", "courses"),
                Aggregation.lookup("faculty_details", "academic_details.list_of_courses_enrolled.faculty_id", "faculty_id", "faculty"),
                Aggregation.project()
                        .and("personal_details").as("studentPersonalDetails")
                        .and("academic_details").as("studentAcademicDetails")
                        .and("courses").as("coursesAvailable")
                        .and("faculty").as("facultyDetails")
        );
        AggregationResults<StudentCompleteDetails> results = mongoTemplate.aggregate(agg, "student_personal_details", StudentCompleteDetails.class);
        StudentCompleteDetails studentCompleteDetails = new StudentCompleteDetails();
        StudentPersonalDetails studentPersonalDetails = new StudentPersonalDetails();
        StudentAcademicDetails studentAcademicDetails = new StudentAcademicDetails();
        CoursesAvailable coursesAvailable = new CoursesAvailable();
        FacultyDetails facultyDetails = new FacultyDetails();
        BeanUtils.copyProperties(results.getRawResults(),studentPersonalDetails);
        BeanUtils.copyProperties(studentPersonalDetails,studentCompleteDetails);
        BeanUtils.copyProperties(results.getRawResults(),studentAcademicDetails);
        BeanUtils.copyProperties(studentAcademicDetails,studentCompleteDetails);
        BeanUtils.copyProperties(results.getRawResults(),coursesAvailable);
        BeanUtils.copyProperties(coursesAvailable,studentCompleteDetails);
        BeanUtils.copyProperties(results.getRawResults(),facultyDetails);
        BeanUtils.copyProperties(facultyDetails,studentCompleteDetails);
        return results.getMappedResults();
    }
}
