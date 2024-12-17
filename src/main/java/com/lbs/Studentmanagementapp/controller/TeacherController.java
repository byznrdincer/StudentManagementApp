package com.lbs.Studentmanagementapp.controller;

import com.lbs.Studentmanagementapp.dto.TeacherDTO;
import com.lbs.Studentmanagementapp.dto.TeacherSaveDTO;
import com.lbs.Studentmanagementapp.dto.TeacherUpdateDTO;
import com.lbs.Studentmanagementapp.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    // Öğretmen kaydetme
    @PostMapping(path = "/save")
    public String saveTeacher(@RequestBody TeacherSaveDTO teacherSaveDTO) {
        String teacherName = teacherService.addTeacher(teacherSaveDTO);
        return "Teacher " + teacherName + " added successfully!";
    }

    // Tüm öğretmenleri alma
    @GetMapping("/getAllTeachers")
    public List<TeacherDTO> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    // Öğretmen güncelleme
    @PutMapping(path = "/update")
    public String updateTeacher(@RequestBody TeacherUpdateDTO teacherUpdateDTO) {
        String teacherName = teacherService.updateTeacher(teacherUpdateDTO);
        if (teacherName != null) {
            return "Teacher " + teacherName ;
        } else {
            return "Teacher ID not found!";
        }
    }

    // Öğretmen silme
    @DeleteMapping(path = "/delete/{id}")
    public String deleteTeacher(@PathVariable(value = "id") int id) {
        boolean isDeleted = teacherService.deleteTeacher(id);
        if (isDeleted) {
            return "Teacher with ID " + id + " deleted successfully!";
        } else {
            return "Teacher ID " + id + " not found!";
        }
    }
}
