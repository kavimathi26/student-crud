package com.college.data.service;

import com.college.data.entity.FacultyDetails;
import com.college.data.repository.FacultyDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacultyDetailsService {
    @Autowired
    FacultyDetailsRepository facultyDetailsRepository;
    public void enrollFaculty(FacultyDetails facultyDetails) {
        facultyDetailsRepository.enrollFaculty(facultyDetails);
    }
}
