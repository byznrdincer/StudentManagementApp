package com.lbs.Studentmanagementapp.repo;

import com.lbs.Studentmanagementapp.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepo extends JpaRepository<Enrollment,Integer> {
}
