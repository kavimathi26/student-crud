package com.college.data.service.impl;

import com.college.data.entity.StudentAcademicDetails;
import com.college.data.repository.StudentAcademicDetailsRepository;
import com.college.data.service.StudentAcademicDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentAcademicDetailsServiceImpl implements StudentAcademicDetailsService {
    @Autowired
    StudentAcademicDetailsRepository studentAcademicDetailsRepository;
    public void enrollStudentAcademicDetails(StudentAcademicDetails studentAcademicDetails) {
             studentAcademicDetailsRepository.enrollStudentAcademicDetails(studentAcademicDetails);

    }
}
