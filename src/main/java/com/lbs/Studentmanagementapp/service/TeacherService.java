package com.lbs.Studentmanagementapp.service;

import com.lbs.Studentmanagementapp.dto.TeacherDTO;
import com.lbs.Studentmanagementapp.dto.TeacherLoginDTO;
import com.lbs.Studentmanagementapp.dto.TeacherSaveDTO;
import com.lbs.Studentmanagementapp.dto.TeacherUpdateDTO;

import java.util.List;

public interface TeacherService {
    String addTeacher(TeacherSaveDTO teacherSaveDTO);

    List<TeacherDTO> getAllTeachers();

    String updateTeacher(TeacherUpdateDTO teacherUpdateDTO);
    boolean validateTeacherLogin(TeacherLoginDTO teacherLoginDTO);

    boolean deleteTeacher(int id);
    TeacherDTO getTeacherById(int id);

}
