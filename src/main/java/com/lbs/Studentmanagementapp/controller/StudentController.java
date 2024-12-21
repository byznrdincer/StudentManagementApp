package com.lbs.Studentmanagementapp.controller;

import com.lbs.Studentmanagementapp.dto.StudentDTO;
import com.lbs.Studentmanagementapp.dto.StudentLoginDTO;
import com.lbs.Studentmanagementapp.dto.StudentSaveDTO;
import com.lbs.Studentmanagementapp.dto.StudentUpdateDTO;
import com.lbs.Studentmanagementapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Öğrenci giriş doğrulama

    @ResponseBody
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody StudentLoginDTO loginDTO) {
        // Giriş işlemleri
        return ResponseEntity.ok(new HashMap<String, String>() {{
            put("message", "Giriş başarılı!");
        }});
    }


    @PostMapping(path = "/save")
    public ResponseEntity<Map<String, String>> saveStudent(@RequestBody StudentSaveDTO studentSaveDTO) {
        String stname = studentService.addStudent(studentSaveDTO);

        Map<String, String> response = new HashMap<>();
        response.put("message", stname);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getAllStudents")
    public List<StudentDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Map<String, String>> updateStudent(@RequestBody StudentUpdateDTO studentUpdateDTO) {
        String stname = studentService.updateStudent(studentUpdateDTO);

        Map<String, String> response = new HashMap<>();
        response.put("message", stname);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Map<String, String>> deleteStudent(@PathVariable(value = "id") int id) {
        boolean deleteStudent = studentService.deleteStudent(id);

        Map<String, String> response = new HashMap<>();
        if (deleteStudent) {
            response.put("message", "Öğrenci silindi!");
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Öğrenci silinemedi!");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
