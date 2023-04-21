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

        StudentPersonalDetailsDTO studentPersonalDetailsDTO = new StudentPersonalDetailsDTO();
        BeanUtils.copyProperties(studentPersonalDetails, studentPersonalDetailsDTO);
        studentCompleteDetailsDTO.setStudentPersonalDetails(studentPersonalDetailsDTO);

        StudentAcademicDetailsDTO studentAcademicDetailsDTO = new StudentAcademicDetailsDTO();
        BeanUtils.copyProperties(studentAcademicDetails, studentAcademicDetailsDTO);
        studentCompleteDetailsDTO.setStudentAcademicDetails(studentAcademicDetailsDTO);

        List<CoursesEnrolledDTO> coursesEnrolledDTO = new ArrayList<>();
        studentAcademicDetails.getListOfCoursesEnrolled().stream().forEach(courseEnrolledByStudent -> {
            CoursesEnrolledDTO coursesEnrolledDTOs = new CoursesEnrolledDTO();
            FacultyDetailsDTO facultyDetailsDTO = new FacultyDetailsDTO();
            CoursesAvailable coursesAvailable = coursesAvailableService.getCourseDetailsWithCourseCode(courseEnrolledByStudent.getCourseCode());
            FacultyDetails facultyDetails = facultyDetailsService.getFacultyDetails(courseEnrolledByStudent.getFacultyId());
            BeanUtils.copyProperties(facultyDetails,facultyDetailsDTO);
            coursesEnrolledDTOs.setFacultyDetails(facultyDetailsDTO);
            BeanUtils.copyProperties(coursesAvailable,coursesEnrolledDTOs);
            coursesEnrolledDTO.add(coursesEnrolledDTOs);
        });

        studentCompleteDetailsDTO.setCoursesEnrolled(coursesEnrolledDTO);
        return studentCompleteDetailsDTO;
    }

}