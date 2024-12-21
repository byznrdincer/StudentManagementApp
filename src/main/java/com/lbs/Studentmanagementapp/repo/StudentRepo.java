package com.lbs.Studentmanagementapp.repo;

import com.lbs.Studentmanagementapp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student, Integer> {
    Optional<Student> findByStudentNameAndStudentId(String studentName, int studentId);
}
