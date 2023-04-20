package com.college.data.entity;

import com.college.data.dao.CoursesAvailableDAO;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = CoursesAvailableDAO.COURSE)
@Data
public class CoursesAvailable {

    @Field(name = "course_regulation_code")
    private String courseRegulationCode;
    @Field(name = "course_title")
    private String courseTitle;
    @Field(name = "course_credit")
    private String courseCredit;
    @Field(name = "course_branch")
    private String courseBranch;

}
