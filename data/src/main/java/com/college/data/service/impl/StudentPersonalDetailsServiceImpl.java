package com.college.data.service.impl;

import com.college.data.entity.StudentPersonalDetails;
import com.college.data.repository.StudentPersonalDetailsRepository;
import com.college.data.service.StudentPersonalDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentPersonalDetailsServiceImpl implements StudentPersonalDetailsService {
    @Autowired
    StudentPersonalDetailsRepository studentPersonalDetailsRepository;
    public void enrollStudentPersonalDetails(StudentPersonalDetails studentPersonalDetails) {
        studentPersonalDetailsRepository.enrollStudentPersonalDetails(studentPersonalDetails);
    }
}
