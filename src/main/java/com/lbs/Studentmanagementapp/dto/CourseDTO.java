package com.lbs.Studentmanagementapp.dto;

public class CourseDTO {
    private int courseId;
    private String courseName;

    // Parametreli constructor
    public CourseDTO(int courseId, String coursename, String syllabus, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
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

