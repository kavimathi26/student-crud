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
//        CoursesAvailable coursesAvailablee = coursesAvailableService.getCourseDetailsWithCourseCode("");
        List<FacultyDetails> facultyDetailss = facultyDetailsService.getFacultyDetailsForAGivenCourseCode("");

        List<String> courses = studentAcademicDetails.getListOfCoursesEnrolled().stream().map(CourseEnrolledByStudent::getCourseCode).collect(Collectors.toList());
        System.out.println("courses "+courses);
        List<CoursesAvailable> coursesAvailable = coursesAvailableService.getCourseDetailsForAParticularRollNo(rollNo);//(courses)
//        coursesAvailable.stream().forEach(coursesAvailable1 -> {
//            coursesAvailable1.getCourseRegulationCode()
//        });
        List<FacultyDetails> facultyDetails = facultyDetailsService.getFacultyDetailsForAGivenRollNo(rollNo);

        StudentPersonalDetailsDTO studentPersonalDetailsDTO = new StudentPersonalDetailsDTO();
        BeanUtils.copyProperties(studentPersonalDetails, studentPersonalDetailsDTO);
        studentCompleteDetailsDTO.setStudentPersonalDetails(studentPersonalDetailsDTO);

        StudentAcademicDetailsDTO studentAcademicDetailsDTO = new StudentAcademicDetailsDTO();
        BeanUtils.copyProperties(studentAcademicDetails,studentAcademicDetailsDTO);
        studentCompleteDetailsDTO.setStudentAcademicDetails(studentAcademicDetailsDTO);


//        List<CoursesAvailable> coursesAvailableList = new ArrayList<>();
//        List<List<FacultyDetails>> facultyDetailsList = new ArrayList<>();
//        List<CoursesEnrolledDTO> coursesEnrolledDT = new ArrayList<>();
//        List<FacultyDetailsDTO> facultyDetailsDTOO = new ArrayList<>();
//        CoursesEnrolledDTO coursesEnrolledDTO = new CoursesEnrolledDTO();
//        FacultyDetailsDTO facultyDetailsDTO = new FacultyDetailsDTO();
//        for(String course : courses) {
//            CoursesAvailable coursesAvailablee = coursesAvailableService.getCourseDetailsWithCourseCode(course);
//            coursesAvailableList.add(coursesAvailablee);
//            List<FacultyDetails> facultyDetailsList1 = facultyDetailsService.getFacultyDetailsForAGivenCourseCode(course);
//            facultyDetailsList.add(facultyDetailsList1);
//            BeanUtils.copyProperties(coursesAvailableList, coursesEnrolledDTO);
//            BeanUtils.copyProperties(facultyDetailsList, facultyDetailsDTO);
//            coursesEnrolledDTO.setFacultyDetails(facultyDetailsDTOO);
////            studentCompleteDetailsDTO.setCoursesEnrolled(coursesEnrolledDTO);
//            System.out.println("coursesEnrolledDT "+coursesEnrolledDT);
//            System.out.println("facultyDetailsDTOO "+facultyDetailsDTOO);
//        }
//
//        System.out.println("coursesAvailableList "+coursesAvailableList);
//        System.out.println("facultyDetailsList "+facultyDetailsList);
//        studentCompleteDetailsDTO.setCoursesEnrolled(coursesEnrolledDT);
//
//        System.out.println("coursesEnrolledDT "+coursesEnrolledDT);
//        System.out.println("facultyDetailsDTOO "+facultyDetailsDTOO);



        List<CoursesEnrolledDTO> coursesEnrolledDTOS = new ArrayList<>();
        List<FacultyDetailsDTO> facultyDetailsDTOS = new ArrayList<>();
        for(String course: courses) {
            CoursesEnrolledDTO coursesEnrolledDTOz = new CoursesEnrolledDTO();
            FacultyDetailsDTO facultyDetailsDTO = new FacultyDetailsDTO();
            List<FacultyDetailsDTO> facultyDetailsDTOz = new ArrayList<>();
            CoursesAvailable coursesAvailablee = coursesAvailableService.getCourseDetailsWithCourseCode(course);
            List<FacultyDetails> facultyDetails1 = facultyDetailsService.getFacultyDetailsForAGivenCourseCode(course);
            List<FacultyDetailsDTO> facultyDetailsDTOO = new ArrayList<>();
        for (FacultyDetails facultyDetail : facultyDetails1) {
            FacultyDetailsDTO facultyDetailsDTO1 = new FacultyDetailsDTO();
            BeanUtils.copyProperties(facultyDetail, facultyDetailsDTO1);
            facultyDetailsDTOO.add(facultyDetailsDTO1);
        }
//            BeanUtils.copyProperties(facultyDetails1,facultyDetailsDTO);
            coursesEnrolledDTOz.setFacultyDetails(facultyDetailsDTOO);
//            BeanUtils.copyProperties(facultyDetailsDTO,facultyDetailsDTOz);
//            BeanUtils.copyProperties(facultyDetailsDTOz,facultyDetailsDTOS);
//            coursesEnrolledDTOz.setFacultyDetails(facultyDetailsDTOS);
            BeanUtils.copyProperties(coursesAvailablee,coursesEnrolledDTOz);
            coursesEnrolledDTOS.add(coursesEnrolledDTOz);
        }
        studentCompleteDetailsDTO.setCoursesEnrolled(coursesEnrolledDTOS);















        List<FacultyDetailsDTO> facultyDetailsDTOz = new ArrayList<>();
        for (FacultyDetails facultyDetail : facultyDetails) {
            FacultyDetailsDTO facultyDetailsDTO1 = new FacultyDetailsDTO();
            BeanUtils.copyProperties(facultyDetail, facultyDetailsDTO1);
            facultyDetailsDTOz.add(facultyDetailsDTO1);
        }






//        studentCompleteDetailsDTO.setCoursesEnrolled(coursesEnrolledDTO);

//        List<CoursesEnrolledDTO> coursesEnrolledDTOO = new ArrayList<>();
//
//
//        List<FacultyDetailsDTO> facultyDetailsDTO = new ArrayList<>();
//        for (FacultyDetails facultyDetail : facultyDetails) {
//            FacultyDetailsDTO facultyDetailsDTO1 = new FacultyDetailsDTO();
//            BeanUtils.copyProperties(facultyDetail, facultyDetailsDTO1);
//            facultyDetailsDTO.add(facultyDetailsDTO1);
//        }
//
//        List<CoursesEnrolledDTO> coursesEnrolledDTOS = new ArrayList<>();
//        List<FacultyDetailsDTO> facultyDetailsDTOS = new ArrayList<>();
//        for(CoursesAvailable coursesAvailable1: coursesAvailable) {
////            List<FacultyDetails> facultyDetailsList = new ArrayList<>();
////            for(String course : courses) {
////                facultyDetailsList = facultyDetailsService.getFacultyDetailsForAGivenCourseCode(course);
////                BeanUtils.copyProperties(facultyDetailsList,facultyDetailsDTOS);
////                facultyDetailsDTOS.add();
////            }
//            CoursesEnrolledDTO coursesEnrolledDTO = new CoursesEnrolledDTO();
//            FacultyDetailsDTO facultyDetailsDTO1 = new FacultyDetailsDTO();
////            BeanUtils.copyProperties(facultyDetailsList,facultyDetailsDTO1);
//            BeanUtils.copyProperties(coursesAvailable1,coursesEnrolledDTO);
////            BeanUtils.copyProperties(facultyDetailsDTO,coursesEnrolledDTOS);
//
////            coursesEnrolledDTO.setFacultyDetails();
////            coursesEnrolledDTO.setFacultyDetails(facultyDetailsDTO);
//            coursesEnrolledDTOS.add(coursesEnrolledDTO);
//        }
//        studentCompleteDetailsDTO.setCoursesEnrolled(coursesEnrolledDTOS);
//        System.out.println(coursesEnrolledDTOS);




return studentCompleteDetailsDTO;
    }

}

//    List<CoursesEnrolledDTO> coursesEnrolledDTOS = new ArrayList<>();
//    List<FacultyDetailsDTO> facultyDetailsDTOS = new ArrayList<>();
//        for(String course: courses) {
//                CoursesEnrolledDTO coursesEnrolledDTOz = new CoursesEnrolledDTO();
//                FacultyDetailsDTO facultyDetailsDTOz = new FacultyDetailsDTO();
//                CoursesAvailable coursesAvailablee = coursesAvailableService.getCourseDetailsWithCourseCode(course);
//                List<FacultyDetails> facultyDetails1 = facultyDetailsService.getFacultyDetailsForAGivenCourseCode(course);
//        BeanUtils.copyProperties(facultyDetails1,facultyDetailsDTOz);
//        coursesEnrolledDTOz.setFacultyDetails(facultyDetailsDTOz);
//        BeanUtils.copyProperties(coursesAvailablee,coursesEnrolledDTOz);
//        coursesEnrolledDTOS.add(coursesEnrolledDTOz);
//        }
//        studentCompleteDetailsDTO.setCoursesEnrolled(coursesEnrolledDTOS);