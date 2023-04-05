package com.college.data.service;

import com.college.data.entity.StudentPersonalDetails;
import com.college.data.repository.StudentPersonalDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentPersonalDetailsService {
    @Autowired
    StudentPersonalDetailsRepository studentPersonalDetailsRepository;
    public void enrollStudentPersonalDetails(StudentPersonalDetails studentPersonalDetails) {
        studentPersonalDetailsRepository.enrollStudentPersonalDetails(studentPersonalDetails);
    }
}
