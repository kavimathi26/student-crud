package com.college.data.service.impl;

import com.college.data.dao.impl.StudentCompleteDetailsDAOImpl;
import com.college.data.entity.ApiResponse;
import com.college.data.entity.StudentCompleteDetails;
import com.college.data.entity.StudentPersonalDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentCompleteDetailsServiceImpl {
    private final StudentCompleteDetailsDAOImpl studentCompleteDetailsDAOImpl;
    public List<StudentCompleteDetails> viewDetailsOfAParticularStudent(String rollNo) {
    return studentCompleteDetailsDAOImpl.viewDetailsOfAParticularStudent(rollNo);
    }

}
