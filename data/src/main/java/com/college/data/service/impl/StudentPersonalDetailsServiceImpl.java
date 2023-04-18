package com.college.data.service.impl;

import com.college.data.constant.StatusChange;
import com.college.data.entity.ApiResponse;
import com.college.data.entity.StudentPersonalDetails;
import com.college.data.dao.impl.StudentPersonalDetailsDAOImpl;
import com.college.data.service.StudentPersonalDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class StudentPersonalDetailsServiceImpl implements StudentPersonalDetailsService {
    private final StudentPersonalDetailsDAOImpl studentPersonalDetailsDAOImpl;
    public void enrollStudentPersonalDetails(StudentPersonalDetails studentPersonalDetails) {
            if(Objects.isNull(studentPersonalDetailsDAOImpl.findStudentDetail(studentPersonalDetails.getRollNo()))) {
                studentPersonalDetails.setCreatedAt(new Date());
                studentPersonalDetails.setStatus(StatusChange.ACTIVE);
                studentPersonalDetailsDAOImpl.enrollStudentPersonalDetails(studentPersonalDetails);
            }else {
                throw new DataIntegrityViolationException("Data already exists.");
            }
    }

    public ApiResponse updateStudentPersonalDetails(String rollNo, String emailId) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            if((Objects.nonNull(studentPersonalDetailsDAOImpl.findStudentDetail(rollNo)))) {
                studentPersonalDetailsDAOImpl.updateStudentPersonalDetails(rollNo, emailId);
                apiResponse.setMessage("e-mail id updated for "+ rollNo);
                apiResponse.setSuccess(true);
            }else {
                throw new NoSuchFieldException("No such data found");
            }
        }
        catch (NoSuchFieldException e) {
            apiResponse.setMessage("No data found");
            apiResponse.setSuccess(false);
        }
        catch (Exception e) {
        apiResponse.setMessage(e.getMessage());
        apiResponse.setSuccess(false);
                }
        return apiResponse;
    }
    public ApiResponse updateEntireDetailsOfAParticularStudent(StudentPersonalDetails studentPersonalDetails) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            studentPersonalDetailsDAOImpl.updateEntireDetailsOfAParticularStudent(studentPersonalDetails);
            apiResponse.setMessage("Details updated for "+studentPersonalDetails.getRollNo());
            apiResponse.setSuccess(true);
        }
        catch (Exception e) {
            apiResponse.setMessage(e.getMessage());
            apiResponse.setSuccess(false);
        }
        return apiResponse;
    }

    public ApiResponse updateStatus(String rollNo) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            if((Objects.nonNull(studentPersonalDetailsDAOImpl.findStudentDetail(rollNo)))) {
                studentPersonalDetailsDAOImpl.updateStatus(rollNo);
                apiResponse.setMessage("status for "+rollNo+" is updated");
                apiResponse.setSuccess(true);
            }else {
                throw new NoSuchFieldException("No such data found");
            }
        }
        catch (NoSuchFieldException e) {
            apiResponse.setMessage(e.getMessage());
            apiResponse.setSuccess(false);
        }
        catch (Exception e) {
            apiResponse.setMessage(e.getMessage());
            apiResponse.setSuccess(false);
        }
        return apiResponse;
    }

    public StudentPersonalDetails findStudentDetail(String rollNo) {
        return studentPersonalDetailsDAOImpl.findStudentDetail(rollNo);
    }
}
