package com.college.data.service.impl;

import com.college.data.controller.response.student_complete_details.StudentCompleteDetailsDTO;
import com.college.data.dao.CoursesAvailableDAO;
import com.college.data.dao.impl.*;
import com.college.data.entity.CoursesAvailable;
import com.college.data.entity.FacultyDetails;
import com.college.data.entity.StudentAcademicDetails;
import com.college.data.entity.StudentPersonalDetails;
import com.college.data.service.StudentAcademicDetailsService;
import com.college.data.service.StudentPersonalDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentCompleteDetailsServiceImpl {
    private final StudentPersonalDetailsServiceImpl studentPersonalDetailsService;
    private final StudentAcademicDetailsServiceImpl studentAcademicDetailsService;
    private final CoursesAvailableServiceImpl coursesAvailableService;
    private final FacultyDetailsServiceImpl facultyDetailsService;
    public StudentCompleteDetailsDTO viewDetailsOfAParticularStudent(String rollNo) {
        //personal->academic->course->faculty
        StudentCompleteDetailsDTO studentCompleteDetailsDTO = new StudentCompleteDetailsDTO();
        StudentPersonalDetails studentPersonalDetails = studentPersonalDetailsService.findStudentDetail(rollNo);
        StudentAcademicDetails studentAcademicDetails = studentAcademicDetailsService.findStudentDetail(rollNo);
        List<CoursesAvailable> coursesAvailables = coursesAvailableService.getCourseDetailsForAParticularRollNo(rollNo);
        List<FacultyDetails> facultyDetails = facultyDetailsService.getFacultyDetailsForAGivenRollNo(rollNo);

return null;
    }

}
