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
import java.util.Optional;

@Service
public class TeacherServiceIMPL implements TeacherService {

    @Autowired
    private TeacherRepo teacherRepo;

    // Öğretmen ekleme
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

    // Tüm öğretmenleri listeleme
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

    // Öğretmen güncelleme
    @Override
    public String updateTeacher(TeacherUpdateDTO teacherUpdateDTO) {
        Optional<Teacher> teacherOpt = teacherRepo.findById(teacherUpdateDTO.getTeacherid());

        if (teacherOpt.isPresent()) {
            Teacher teacher = teacherOpt.get();
            teacher.setTeachername(teacherUpdateDTO.getTeachername());
            teacher.setAddress(teacherUpdateDTO.getAddress());
            teacher.setPhone(teacherUpdateDTO.getPhone());
            teacherRepo.save(teacher);
            return "Teacher " + teacher.getTeachername() ;
        } else {
            return "Teacher ID not found!";
        }
    }

    // Öğretmen silme
    @Override
    public boolean deleteTeacher(int id) {
        if (teacherRepo.existsById(id)) {
            teacherRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
