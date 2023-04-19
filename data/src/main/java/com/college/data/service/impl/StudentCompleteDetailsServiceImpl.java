package com.college.data.service.impl;

import com.college.data.controller.response.student_complete_details.*;
import com.college.data.entity.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentCompleteDetailsServiceImpl {
    private final StudentPersonalDetailsServiceImpl studentPersonalDetailsService;
    private final StudentAcademicDetailsServiceImpl studentAcademicDetailsService;
    private final CoursesAvailableServiceImpl coursesAvailableService;
    private final FacultyDetailsServiceImpl facultyDetailsService;
    public StudentCompleteDetailsDTO viewDetailsOfAParticularStudent(String rollNo) {
        StudentCompleteDetailsDTO studentCompleteDetailsDTO = new StudentCompleteDetailsDTO();
        StudentPersonalDetails studentPersonalDetails = studentPersonalDetailsService.findStudentDetail(rollNo);
        StudentAcademicDetails studentAcademicDetails = studentAcademicDetailsService.findStudentDetail(rollNo);
        List<String> courses = studentAcademicDetails.getListOfCoursesEnrolled().stream().map(CourseEnrolledByStudent::getCourseCode).collect(Collectors.toList());
        List<CoursesAvailable> coursesAvailable = coursesAvailableService.getCourseDetailsForAParticularRollNo(courses);
        coursesAvailable.stream().forEach(coursesAvailable1 -> {
            coursesAvailable1.getCourseRegulationCode()
        });
        List<FacultyDetails> facultyDetails = facultyDetailsService.getFacultyDetailsForAGivenRollNo(rollNo);

        StudentAcademicDetailsDTO studentAcademicDetailsDTO = new StudentAcademicDetailsDTO();
        BeanUtils.copyProperties(studentAcademicDetails,studentAcademicDetailsDTO);
        studentCompleteDetailsDTO.setStudentAcademicDetails(studentAcademicDetailsDTO);

        StudentPersonalDetailsDTO studentPersonalDetailsDTO = new StudentPersonalDetailsDTO();
        BeanUtils.copyProperties(studentPersonalDetails, studentPersonalDetailsDTO);
        studentCompleteDetailsDTO.setStudentPersonalDetails(studentPersonalDetailsDTO);

        List<FacultyDetailsDTO> facultyDetailsDTO = new ArrayList<>();
        for (FacultyDetails facultyDetails1 : facultyDetails) {
            FacultyDetailsDTO facultyDetailsDTO1 = new FacultyDetailsDTO();
            BeanUtils.copyProperties(facultyDetails1, facultyDetailsDTO1);
            facultyDetailsDTO.add(facultyDetailsDTO1);
        }

        List<CoursesEnrolledDTO> coursesEnrolledDTOS = new ArrayList<>();
        for(CoursesAvailable coursesAvailable1: coursesAvailable) {
            CoursesEnrolledDTO coursesEnrolledDTO = new CoursesEnrolledDTO();
            BeanUtils.copyProperties(coursesAvailable1,coursesEnrolledDTO);
//            BeanUtils.copyProperties(facultyDetailsDTO,coursesEnrolledDTOS);
            coursesEnrolledDTO.setFacultyDetails(facultyDetailsDTO);
            coursesEnrolledDTOS.add(coursesEnrolledDTO);
        }
        studentCompleteDetailsDTO.setCoursesEnrolled(coursesEnrolledDTOS);
        System.out.println(coursesEnrolledDTOS);




return studentCompleteDetailsDTO;
    }

}
