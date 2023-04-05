package com.college.data.service;

import com.college.data.entity.StudentAcademicDetails;
import com.college.data.repository.StudentAcademicDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentAcademicDetailsService {
    @Autowired
    StudentAcademicDetailsRepository studentAcademicDetailsRepository;
    public void enrollStudentAcademicDetails(StudentAcademicDetails studentAcademicDetails) {
        studentAcademicDetailsRepository.enrollStudentAcademicDetails(studentAcademicDetails);
    }
}
