package com.lbs.Studentmanagementapp.service;

import com.lbs.Studentmanagementapp.dto.CourseDTO;
import com.lbs.Studentmanagementapp.dto.CourseSaveDTO;
import com.lbs.Studentmanagementapp.dto.CourseUpdateDTO;

import java.util.List;

public interface CourseService {
    String addCourse(CourseSaveDTO courseSaveDTO);

    List<CourseDTO> getAllCourses();

    String updateCourse(CourseUpdateDTO courseUpdateDTO);

    boolean deleteCourse(int id);
}
