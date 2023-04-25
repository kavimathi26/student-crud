package com.college.data.controller;

import com.college.data.controller.response.student_complete_details.StudentCompleteDetailsDTO;
import com.college.data.service.impl.StudentCompleteDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentCompleteDetailsController {
    private final StudentCompleteDetailsServiceImpl studentCompleteDetailsServiceImpl;
    @GetMapping("/view-details/{rollNo}")
    public StudentCompleteDetailsDTO viewDetailsOfAParticularStudent(@PathVariable String rollNo) {
        return studentCompleteDetailsServiceImpl.viewDetailsOfAParticularStudent(rollNo);
    }
}
