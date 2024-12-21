package com.lbs.Studentmanagementapp.controller;

import com.lbs.Studentmanagementapp.dto.TeacherDTO;
import com.lbs.Studentmanagementapp.dto.TeacherLoginDTO;
import com.lbs.Studentmanagementapp.dto.TeacherSaveDTO;
import com.lbs.Studentmanagementapp.dto.TeacherUpdateDTO;
import com.lbs.Studentmanagementapp.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> saveTeacher(@RequestBody TeacherSaveDTO teacherSaveDTO) {
        String teacherName = teacherService.addTeacher(teacherSaveDTO);
        if (teacherName != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("{\"message\": \"Teacher " + teacherName + " added successfully!\"}");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Failed to add teacher\"}");
        }
    }


    // Öğretmen giriş
    @PostMapping("/login")
    public ResponseEntity<String> loginTeacher(@RequestBody TeacherLoginDTO teacherLoginDTO) {
        boolean isValid = teacherService.validateTeacherLogin(teacherLoginDTO);

        if (isValid) {
            return ResponseEntity.ok("{\"message\": \"Giriş başarılı!\"}");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("{\"message\": \"Geçersiz kullanıcı ID!\"}");
        }
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
            return "Teacher " + teacherName;
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
