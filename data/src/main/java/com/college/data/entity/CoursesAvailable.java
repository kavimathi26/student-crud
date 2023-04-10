package com.college.data.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import static com.college.data.entity.ConstantFile.COURSE;

@Document(collection = COURSE)
@Data
public class CoursesAvailable implements ConstantFile {

    @Field(name = "course_regulation_code")
    private String courseRegulationCode;
    @Field(name = "course_title")
    private String courseTitle1;
    @Field(name = "course_credit")
    private String courseCredit;
    @Field(name = "course_branch")
    private String courseBranch;

}
