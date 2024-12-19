package com.lbs.Studentmanagementapp.controller;

import com.lbs.Studentmanagementapp.dto.CourseDTO;
import com.lbs.Studentmanagementapp.dto.CourseSaveDTO;
import com.lbs.Studentmanagementapp.dto.CourseUpdateDTO;
import com.lbs.Studentmanagementapp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // Course ekleme
    @PostMapping(path = "/save")
    public ResponseEntity<String> saveCourse(@RequestBody CourseSaveDTO courseSaveDTO) {
        String course = courseService.addCourse(courseSaveDTO);
        return new ResponseEntity<>(course, HttpStatus.CREATED); // Başarı durumunda 201 döner
    }

    // Tüm kursları listeleme
    @GetMapping("/getAllCourses")
    public ResponseEntity<List<CourseDTO>> getAllCourses() {
        List<CourseDTO> allCourses = courseService.getAllCourses();
        return new ResponseEntity<>(allCourses, HttpStatus.OK); // 200 OK ile döner
    }

    // Kurs güncelleme
    @PutMapping(path = "/update")
    public ResponseEntity<String> updateCourse(@RequestBody CourseUpdateDTO courseUpdateDTO) {
        String course = courseService.updateCourse(courseUpdateDTO);
        return new ResponseEntity<>(course, HttpStatus.OK); // Başarı durumu 200 döner
    }

    // Kurs silme
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable(value = "id") int id) {
        boolean isDeleted = courseService.deleteCourse(id);
        if (isDeleted) {
            return new ResponseEntity<>("Course deleted successfully", HttpStatus.OK); // Kurs başarılı bir şekilde silindiyse
        } else {
            return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND); // Kurs bulunamazsa
        }
    }
}