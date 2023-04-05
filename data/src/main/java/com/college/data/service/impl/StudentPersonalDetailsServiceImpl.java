package com.college.data.service.impl;

import com.college.data.entity.StudentPersonalDetails;
import com.college.data.repository.StudentPersonalDetailsRepository;
import com.college.data.service.StudentPersonalDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentPersonalDetailsServiceImpl implements StudentPersonalDetailsService {
    private final StudentPersonalDetailsRepository studentPersonalDetailsRepository;
    public void enrollStudentPersonalDetails(StudentPersonalDetails studentPersonalDetails) {
        studentPersonalDetailsRepository.enrollStudentPersonalDetails(studentPersonalDetails);
    }
}
