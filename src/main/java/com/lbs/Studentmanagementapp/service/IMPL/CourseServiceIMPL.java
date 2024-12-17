package com.lbs.Studentmanagementapp.service.IMPL;

import com.lbs.Studentmanagementapp.dto.CourseDTO;
import com.lbs.Studentmanagementapp.dto.CourseSaveDTO;
import com.lbs.Studentmanagementapp.dto.CourseUpdateDTO;
import com.lbs.Studentmanagementapp.entity.Course;
import com.lbs.Studentmanagementapp.repo.CourseRepo;
import com.lbs.Studentmanagementapp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceIMPL implements CourseService {

    @Autowired
    private CourseRepo courseRepo;

    @Override
    public String addCourse(CourseSaveDTO courseSaveDTO) {
        // syllabus ve duration alanları kullanılmadığı için kaldırıldı
        Course course = new Course(
                courseSaveDTO.getCoursename()
        );
        courseRepo.save(course);
        return course.getCoursename(); // Kurs adı döndürülüyor
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        List<Course> getCourses = courseRepo.findAll();
        List<CourseDTO> courseDTOList = new ArrayList<>();
        for (Course course : getCourses) {
            // syllabus ve duration alanları kullanılmadığı için kaldırıldı
            CourseDTO courseDTO = new CourseDTO(
                    course.getCourseid(),
                    course.getCoursename()
            );
            courseDTOList.add(courseDTO);
        }
        return courseDTOList; // Kurs listesi döndürülüyor
    }

    @Override
    public String updateCourse(CourseUpdateDTO courseUpdateDTO) {
        Optional<Course> optionalCourse = courseRepo.findById(courseUpdateDTO.getCourseid());
        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();
            course.setCoursename(courseUpdateDTO.getCoursename()); // sadece course adı güncelleniyor

            courseRepo.save(course);
            return course.getCoursename(); // Güncellenmiş kurs adı döndürülüyor
        }
        return null; // Kurs bulunamazsa null döndürülüyor
    }

    @Override
    public boolean deleteCourse(int id) {
        if (courseRepo.existsById(id)) {
            courseRepo.deleteById(id);
            return true; // Silme işlemi başarılı
        }
        return false; // Kurs bulunamadı
    }
}