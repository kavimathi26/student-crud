package com.college.data.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "courses_available")

public class CoursesAvailable {
    public CoursesAvailable(String courseRegulationCode, String courseTitle, String courseCredit, String courseBranch) {
        this.courseRegulationCode = courseRegulationCode;
        this.courseTitle = courseTitle;
        this.courseCredit = courseCredit;
        this.courseBranch = courseBranch;
    }

    private String courseRegulationCode; //constant
    private String courseTitle;
    private String courseCredit;
    private String courseBranch;

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
