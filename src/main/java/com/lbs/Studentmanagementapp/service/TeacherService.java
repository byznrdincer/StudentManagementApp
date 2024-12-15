package com.lbs.Studentmanagementapp.service;

import com.lbs.Studentmanagementapp.dto.TeacherDTO;
import com.lbs.Studentmanagementapp.dto.TeacherSaveDTO;
import com.lbs.Studentmanagementapp.dto.TeacherUpdateDTO;

import java.util.List;

public interface TeacherService {
    String addTeacher(TeacherSaveDTO teacherSaveDTO);

    List<TeacherDTO> getAllTeachers();

    String updateTeacher(TeacherUpdateDTO teacherUpdateDTO);

    boolean deleteTeacher(int id);
}
