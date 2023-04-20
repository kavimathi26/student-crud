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
        List<String> faculties = studentAcademicDetails.getListOfCoursesEnrolled().stream().map(CourseEnrolledByStudent::getFacultyId).collect(Collectors.toList());
        StudentPersonalDetailsDTO studentPersonalDetailsDTO = new StudentPersonalDetailsDTO();
        BeanUtils.copyProperties(studentPersonalDetails, studentPersonalDetailsDTO);
        studentCompleteDetailsDTO.setStudentPersonalDetails(studentPersonalDetailsDTO);

        StudentAcademicDetailsDTO studentAcademicDetailsDTO = new StudentAcademicDetailsDTO();
        BeanUtils.copyProperties(studentAcademicDetails, studentAcademicDetailsDTO);
        studentCompleteDetailsDTO.setStudentAcademicDetails(studentAcademicDetailsDTO);

        List<CoursesEnrolledDTO> coursesEnrolledDTO = new ArrayList<>();
        for(int i = 0; i < courses.size(); i++) {
            CoursesEnrolledDTO coursesEnrolledDTOs = new CoursesEnrolledDTO();
            FacultyDetailsDTO facultyDetailsDTO = new FacultyDetailsDTO();
            CoursesAvailable coursesAvailable = coursesAvailableService.getCourseDetailsWithCourseCode(courses.get(i));
            FacultyDetails facultyDetails = facultyDetailsService.getFacultyDetails(faculties.get(i));
            BeanUtils.copyProperties(facultyDetails,facultyDetailsDTO);
            coursesEnrolledDTOs.setFacultyDetails(facultyDetailsDTO);
            BeanUtils.copyProperties(coursesAvailable,coursesEnrolledDTOs);
            coursesEnrolledDTO.add(coursesEnrolledDTOs);
        }
        studentCompleteDetailsDTO.setCoursesEnrolled(coursesEnrolledDTO);
        return studentCompleteDetailsDTO;
    }

}