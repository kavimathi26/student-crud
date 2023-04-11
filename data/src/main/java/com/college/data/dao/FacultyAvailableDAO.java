package com.college.data.dao;

import com.college.data.entity.FacultyDetails;

public interface FacultyAvailableDAO {
    String FACULTY = "faculty_details";
    FacultyDetails findFacultyDetail(FacultyDetails facultyDetails);
    void enrollFaculty(FacultyDetails facultyDetails);
}
