package com.college.data.entity;

import lombok.Data;

import java.util.List;

@Data
public class StudentCompleteDetails {
    private StudentPersonalDetails studentPersonalDetails;
    private StudentAcademicDetails studentAcademicDetails;
    private List<String> facultyIds;
}
