package com.lbs.Studentmanagementapp.service;

import com.lbs.Studentmanagementapp.dto.StudentDTO;
import com.lbs.Studentmanagementapp.dto.StudentLoginDTO;
import com.lbs.Studentmanagementapp.dto.StudentSaveDTO;
import com.lbs.Studentmanagementapp.dto.StudentUpdateDTO;

import java.util.List;

import java.util.List;

public interface StudentService {
    String addStudent(StudentSaveDTO studentSaveDTO);
    List<StudentDTO> getAllStudents();
    String updateStudent(StudentUpdateDTO studentUpdateDTO);
    boolean deleteStudent(int id);
    boolean validateStudentLogin(StudentLoginDTO studentLoginDTO);
    StudentDTO getStudentById(int studentId);

    // Dönüş türü StudentDTO yapıldı
    StudentDTO findById(Long id);
}
