package com.lbs.Studentmanagementapp.service.IMPL;

import com.lbs.Studentmanagementapp.dto.TeacherDTO;
import com.lbs.Studentmanagementapp.dto.TeacherSaveDTO;
import com.lbs.Studentmanagementapp.dto.TeacherUpdateDTO;
import com.lbs.Studentmanagementapp.entity.Teacher;
import com.lbs.Studentmanagementapp.repo.TeacherRepo;
import com.lbs.Studentmanagementapp.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherServiceIMPL implements TeacherService {

    @Autowired
    private TeacherRepo teacherRepo;

    @Override
    public String addTeacher(TeacherSaveDTO teacherSaveDTO) {
        Teacher teacher = new Teacher(
                teacherSaveDTO.getTeachername(),
                teacherSaveDTO.getAddress(),
                teacherSaveDTO.getPhone()
        );
        teacherRepo.save(teacher);
        return teacher.getTeachername();
    }

    @Override
    public List<TeacherDTO> getAllTeachers() {
        List<Teacher> teachers = teacherRepo.findAll();
        List<TeacherDTO> teacherDTOList = new ArrayList<>();
        for (Teacher teacher : teachers) {
            teacherDTOList.add(new TeacherDTO(
                    teacher.getTeacherid(),
                    teacher.getTeachername(),
                    teacher.getAddress(),
                    teacher.getPhone()
            ));
        }
        return teacherDTOList;
    }

    @Override
    public String updateTeacher(TeacherUpdateDTO teacherUpdateDTO) {
        return teacherRepo.findById(teacherUpdateDTO.getTeacherid())
                .map(teacher -> {
                    teacher.setTeachername(teacherUpdateDTO.getTeachername());
                    teacher.setAddress(teacherUpdateDTO.getAddress());
                    teacher.setPhone(teacherUpdateDTO.getPhone());
                    teacherRepo.save(teacher);
                    return teacher.getTeachername();
                })
                .orElse("Teacher ID Not Found");
    }

    @Override
    public boolean deleteTeacher(int id) {
        if (teacherRepo.existsById(id)) {
            teacherRepo.deleteById(id);
            return true;
        }
        System.out.println("Teacher ID Not Found");
        return false;
    }
}
