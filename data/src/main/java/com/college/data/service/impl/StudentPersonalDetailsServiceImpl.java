package com.college.data.service.impl;

import com.college.data.entity.StudentPersonalDetails;
import com.college.data.dao.impl.StudentPersonalDetailsDAOImpl;
import com.college.data.service.StudentPersonalDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentPersonalDetailsServiceImpl implements StudentPersonalDetailsService {
    private final StudentPersonalDetailsDAOImpl studentPersonalDetailsDAOImpl;
    public void enrollStudentPersonalDetails(StudentPersonalDetails studentPersonalDetails) {
        studentPersonalDetailsDAOImpl.enrollStudentPersonalDetails(studentPersonalDetails);
    }
}
