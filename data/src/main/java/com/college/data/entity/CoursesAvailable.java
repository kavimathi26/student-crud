package com.college.data.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "courses_available") //constant file

public class CoursesAvailable {

    @Field(name = "course_regulation_code")
    private String courseRegulationCode;
    @Field(name = "course_title")
    private String courseTitle;
    @Field(name = "course_credit")
    private String courseCredit;
    @Field(name = "course_branch")
    private String courseBranch;

    public CoursesAvailable(String courseRegulationCode, String courseTitle, String courseCredit, String courseBranch) {
        this.courseRegulationCode = courseRegulationCode;
        this.courseTitle = courseTitle;
        this.courseCredit = courseCredit;
        this.courseBranch = courseBranch;
    }

    public String getCourseRegulationCode() {
        return courseRegulationCode;
    }

    public void setCourseRegulationCode(String courseRegulationCode) {
        this.courseRegulationCode = courseRegulationCode;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(String courseCredit) {
        this.courseCredit = courseCredit;
    }

    public String getCourseBranch() {
        return courseBranch;
    }

    public void setCourseBranch(String courseBranch) {
        this.courseBranch = courseBranch;
    }
}
