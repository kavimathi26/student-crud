package com.college.data.service.impl;

import com.college.data.entity.FacultyDetails;
import com.college.data.dao.impl.FacultyDetailsDAOImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FacultyDetailsServiceImpl {
    private final FacultyDetailsDAOImpl facultyDetailsDAOImpl;
    public void enrollFaculty(FacultyDetails facultyDetails) {
//        try {
            facultyDetailsDAOImpl.enrollFaculty(facultyDetails);
//        }
    }
}
