package com.lbs.Studentmanagementapp.repo;

import com.lbs.Studentmanagementapp.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course,Integer> {
}
