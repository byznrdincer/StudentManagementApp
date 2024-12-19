package com.lbs.Studentmanagementapp.repo;

import com.lbs.Studentmanagementapp.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepo extends JpaRepository<Teacher,Integer> {
}
