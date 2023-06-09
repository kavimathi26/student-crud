package com.college.data.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;
@Data
public class CourseEnrolledByStudent {
    @Field(name = "course_code")
    private String courseCode;
    @Field(name = "marks_scored")
    private short marksScored;
    @Field(name = "faculty_id")
    private String facultyId;

}
