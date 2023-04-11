package com.college.data.service.impl;

import com.college.data.entity.ApiResponse;
import com.college.data.entity.StudentPersonalDetails;
import com.college.data.dao.impl.StudentPersonalDetailsDAOImpl;
import com.college.data.service.StudentPersonalDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentPersonalDetailsServiceImpl implements StudentPersonalDetailsService {
    private final StudentPersonalDetailsDAOImpl studentPersonalDetailsDAOImpl;
    public boolean enrollStudentPersonalDetails(StudentPersonalDetails studentPersonalDetails) {
        studentPersonalDetailsDAOImpl.checkForDuplicates(studentPersonalDetails);
        if(studentPersonalDetailsDAOImpl.checkForDuplicates(studentPersonalDetails)==true){
            studentPersonalDetailsDAOImpl.enrollStudentPersonalDetails(studentPersonalDetails);
            return true;
        }
        else {
            return false;
        }
    }
}
