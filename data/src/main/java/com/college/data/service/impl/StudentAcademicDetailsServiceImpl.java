package com.college.data.service.impl;

import com.college.data.entity.StudentAcademicDetails;
import com.college.data.dao.impl.StudentAcademicDetailsDAOImpl;
import com.college.data.service.StudentAcademicDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentAcademicDetailsServiceImpl implements StudentAcademicDetailsService {
    private final StudentAcademicDetailsDAOImpl studentAcademicDetailsDAOImpl;
    @Override
    public void enrollStudentAcademicDetails(StudentAcademicDetails studentAcademicDetails) {
             studentAcademicDetailsDAOImpl.enrollStudentAcademicDetails(studentAcademicDetails);

    }
}
