package com.lbs.Studentmanagementapp.service;


public interface AuthService {
    boolean validateStudent(int studentId, String studentName);
    boolean validateTeacher(int teacherId, String teacherName);
}
