package com.lbs.Studentmanagementapp.service;

import com.lbs.Studentmanagementapp.dto.EnrollmentDTO;
import com.lbs.Studentmanagementapp.dto.EnrollmentSaveDTO;
import com.lbs.Studentmanagementapp.dto.EnrollmentUpdateDTO;

import java.util.List;

public interface EnrollmentService {
    String addEnrollment(EnrollmentSaveDTO enrollmentSaveDTO);

    List<EnrollmentDTO> getAllEnrollments();

    String updateEnrollment(EnrollmentUpdateDTO enrollmentUpdateDTO);

    boolean deleteEnrollment(int id);
    List<EnrollmentDTO> getEnrollmentsByStudentId(int studentId);

}
