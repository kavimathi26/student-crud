package com.college.data.controller;

import com.college.data.entity.ApiResponse;
import com.college.data.entity.StudentCompleteDetails;
import com.college.data.entity.StudentPersonalDetails;
import com.college.data.service.impl.StudentCompleteDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentCompleteDetailsController {
    private final StudentCompleteDetailsServiceImpl studentCompleteDetailsServiceImpl;
    @GetMapping("/view-details/{rollNo}")
    public List<StudentCompleteDetails> viewDetailsOfAParticularStudent(@PathVariable String rollNo) {
        return studentCompleteDetailsServiceImpl.viewDetailsOfAParticularStudent(rollNo);
    }
}
