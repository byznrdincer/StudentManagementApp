package com.lbs.Studentmanagementapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lbs.Studentmanagementapp.service.AuthService; // Interface'i kullanıyoruz

import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AuthService authService; // Interface üzerinden hizmeti alıyoruz

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, Object> payload) {
        int userId = (int) payload.get("id");
        String userName = (String) payload.get("name");

        boolean isStudentValid = authService.validateStudent(userId, userName);
        boolean isTeacherValid = authService.validateTeacher(userId, userName);

        if (isStudentValid) {
            return new ResponseEntity<>("Öğrenci girişi başarılı!", HttpStatus.OK);
        } else if (isTeacherValid) {
            return new ResponseEntity<>("Öğretmen girişi başarılı!", HttpStatus.OK);
        }

        return new ResponseEntity<>("Giriş başarısız!", HttpStatus.UNAUTHORIZED);
    }
}