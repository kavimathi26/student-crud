package com.college.data.service.impl;

import com.college.data.dao.impl.StudentCompleteDetailsDAOImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentCompleteDetailsServiceImpl {
    private final StudentCompleteDetailsDAOImpl studentCompleteDetailsDAOImpl;
    public List<Object> viewDetailsOfAParticularStudent(String rollNo) {
    return studentCompleteDetailsDAOImpl.viewDetailsOfAParticularStudent(rollNo);
    }

}
