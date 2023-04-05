package com.college.data.service.impl;

import com.college.data.entity.FacultyDetails;
import com.college.data.repository.FacultyDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FacultyDetailsServiceImpl {
    private final FacultyDetailsRepository facultyDetailsRepository;
    public void enrollFaculty(FacultyDetails facultyDetails) {
//        try {
            facultyDetailsRepository.enrollFaculty(facultyDetails);
//        }
    }
}
