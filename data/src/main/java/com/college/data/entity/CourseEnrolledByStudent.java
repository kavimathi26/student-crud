package com.college.data.entity;

import org.springframework.data.mongodb.core.mapping.Field;

public class CourseEnrolledByStudent {
    public CourseEnrolledByStudent(String courseCode, short marksScored) {
        this.courseCode = courseCode;
        this.marksScored = marksScored;
    }
    @Field(name = "course_code")
    private String courseCode;
    @Field(name = "marks_scored")
    private short marksScored;


    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public short getMarksScored() {
        return marksScored;
    }

    public void setMarksScored(short marksScored) {
        this.marksScored = marksScored;
    }
}
