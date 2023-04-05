package com.college.data.entity;
public class CourseEnrolledByStudent {
    public CourseEnrolledByStudent(String courseCode, short marksScored) {
        this.courseCode = courseCode;
        this.marksScored = marksScored;
    }

    private String courseCode;
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
