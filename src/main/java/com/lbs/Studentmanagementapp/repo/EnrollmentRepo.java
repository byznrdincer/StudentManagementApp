package com.lbs.Studentmanagementapp.repo;

import com.lbs.Studentmanagementapp.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepo extends JpaRepository<Enrollment, Integer> {
    List<Enrollment> findByStudentStudentId(int studentId);  // Bu şekilde yazın
}

