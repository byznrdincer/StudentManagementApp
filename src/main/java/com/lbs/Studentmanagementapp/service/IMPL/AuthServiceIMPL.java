package com.lbs.Studentmanagementapp.service.IMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lbs.Studentmanagementapp.service.AuthService; // Interface'i kullanıyoruz
import com.lbs.Studentmanagementapp.repo.StudentRepo;
import com.lbs.Studentmanagementapp.repo.TeacherRepo;

@Service
public class AuthServiceIMPL implements AuthService {

    @Autowired
    private StudentRepo studentRepository;

    @Autowired
    private TeacherRepo teacherRepository;

    @Override
    public boolean validateStudent(int studentId, String studentName) {
        // Öğrenci doğrulama işlemleri
        // Örnek:
        return studentRepository.findById(studentId)
                .map(student -> student.getStudentName().equals(studentName))
                .orElse(false);
    }

    @Override
    public boolean validateTeacher(int teacherId, String teacherName) {
        // Öğretmen doğrulama işlemleri
        // Örnek:
        return teacherRepository.findById(teacherId)
                .map(teacher -> teacher.getTeachername().equals(teacherName))
                .orElse(false);
    }
}
