package com.college.data.dao.impl;

import com.college.data.constant.StatusChange;
import com.college.data.dao.StudentPersonalDetailsDAO;
import com.college.data.entity.*;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

import static com.college.data.dao.constant.StudentPersonalDetails.*;


@Repository
@RequiredArgsConstructor
public class StudentPersonalDetailsDAOImpl extends StatusChange implements StudentPersonalDetailsDAO {
    private final MongoTemplate mongoTemplate;
    @Override
    public StudentPersonalDetails findStudentDetail(String rollNo) {
        Query query = new Query().addCriteria(Criteria.where(ROLL_NO).is(rollNo));
        return mongoTemplate.findOne(query, StudentPersonalDetails.class);
    }
    @Override
    public void enrollStudentPersonalDetails(StudentPersonalDetails studentPersonalDetails) {
            mongoTemplate.save(studentPersonalDetails);
    }
    public void updateStudentPersonalDetails(String rollNo, String emailId) {
            Query query = new Query().addCriteria(Criteria.where(ROLL_NO).is(rollNo));
            Update update = new Update();
            update.set(EMAIL_ID,emailId);
            update.set(UPDATED_AT,new Date());
            mongoTemplate.findAndModify(query,update, StudentPersonalDetails.class);
    }

    public void updateEntireDetailsOfAParticularStudent(StudentPersonalDetails studentPersonalDetails) {
        Query query = new Query().addCriteria(Criteria.where(ROLL_NO).is(studentPersonalDetails.getRollNo()));
        Update update = Update.fromDocument(new Document(SET, studentPersonalDetails));
        mongoTemplate.upsert(query,update,StudentPersonalDetails.class);
    }

    public void updateStatus(String rollNo) {
        Query query = new Query().addCriteria(Criteria.where(ROLL_NO).is(rollNo));
        Update update = new Update();
        update.set(STATUS, StatusChange.INACTIVE);
        update.set(UPDATED_AT,new Date());
        mongoTemplate.findAndModify(query,update, StudentPersonalDetails.class);
    }

    public StudentCompleteDetails viewStudentDetailsUsingAggregate(String rollNo) {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where(ROLL_NO).is(rollNo)),
                Aggregation.lookup(STUDENT_PERSONAL_DETAILS, ROLL_NO, ROLL_NO, PERSONAL_DETAILS),
                Aggregation.unwind(PERSONAL_DETAILS),
                Aggregation.lookup(STUDENT_ACADEMIC_DETAILS, ROLL_NO, ROLL_NO, ACADEMIC_DETAILS),
                Aggregation.unwind(ACADEMIC_DETAILS),
                Aggregation.lookup(COURSES_AVAILABLE, COURSE_CODE, COURSE_REGULATION_CODE, COURSES),
                Aggregation.lookup(FACULTY_DETAILS, FACULTY_ID_ENROLLED, FACULTY_ID, FACULTY),
                Aggregation.project()
                        .and(PERSONAL_DETAILS).as(STUDENT_PERSONAL_DETAILS_ALIAS)
                        .and(ACADEMIC_DETAILS).as(STUDENT_ACADEMIC_DETAILS_ALIAS)
                        .and(COURSES).as(COURSES_AVAILABLE_ALIAS)
                        .and(FACULTY).as(FACULTY_DETAILS_ALIAS)
        );
        AggregationResults<StudentCompleteDetails> results = mongoTemplate.aggregate(aggregation, STUDENT_PERSONAL_DETAILS, StudentCompleteDetails.class);
        return results.getMappedResults().get(0);
    }
}
