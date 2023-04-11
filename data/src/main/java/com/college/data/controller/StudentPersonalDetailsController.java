package com.college.data.controller;

import com.college.data.entity.ApiResponse;
import com.college.data.entity.StudentPersonalDetails;
import com.college.data.service.impl.StudentPersonalDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.bson.json.JsonParseException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;

@RestController
@RequestMapping("studentPersonalDetails")
@RequiredArgsConstructor
public class StudentPersonalDetailsController {
    private final StudentPersonalDetailsServiceImpl studentPersonalDetailsServiceImpl;

    @PostMapping("/enroll")

    public ResponseEntity<ApiResponse> enrollStudentPersonalDetails(@RequestBody StudentPersonalDetails studentPersonalDetails) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            if(studentPersonalDetailsServiceImpl.enrollStudentPersonalDetails(studentPersonalDetails)) {
                apiResponse.setMessage("Personal Details of Student Enrolled");
                return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
            }
            else {
                throw new DataIntegrityViolationException("Duplicate Entry. This detail is already Enrolled.");
            }
        } catch (DataIntegrityViolationException e) {
            apiResponse.setMessage(e.getMessage());
            return new ResponseEntity<>(apiResponse, HttpStatus.CONFLICT);
        }
//        catch(HttpClientErrorException.BadRequest e) {
//            apiResponse.setMessage("Check all the fields are entered properly");
//            return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
//        }
        //Collection.utils
        catch (HttpMessageNotReadableException e){
            apiResponse.setMessage("Check all the fields are properly entered");
            return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            apiResponse.setMessage(e.getMessage());
            apiResponse.setErrorCode(HttpStatus.EXPECTATION_FAILED.name());
            return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
