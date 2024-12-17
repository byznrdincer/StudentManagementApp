package com.lbs.Studentmanagementapp.dto;

public class CourseDTO {
    private int courseId;          // Dersi temsil eden benzersiz kimlik
    private String courseName;     // Dersin adı

    // Parametreli constructor
    public CourseDTO(int courseId, String courseName) {
        this.courseId = courseId;
        setCourseName(courseName); // Setter'ı kullanarak atama yapıyoruz
    }

    // Getter ve Setter metodları
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        // Geçersiz değer kontrolü
        if (courseName == null || courseName.trim().isEmpty()) {
            throw new IllegalArgumentException("Course name cannot be null or empty");
        }
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "CourseDTO{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}