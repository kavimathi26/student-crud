package com.college.data.controller.response.student_complete_details;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.List;
@Data
public class FacultyDetailsDTO {
    private String facultyId;
    private String name;
    private String degree;
    private LocalDate dob;
    private String passedOutYear;
    private String department;
    private String designation;
    private List<String> coursesHandled;
}
