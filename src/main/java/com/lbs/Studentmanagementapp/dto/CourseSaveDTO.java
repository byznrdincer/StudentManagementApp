package com.lbs.Studentmanagementapp.dto;

public class CourseSaveDTO {

    private String coursename;

    // No-argument constructor
    public CourseSaveDTO() {
    }

    // All-argument constructor
    public CourseSaveDTO(String coursename) {
        this.coursename = coursename;
    }

    // Getters and Setters
    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    // toString method
    @Override
    public String toString() {
        return "CourseSaveDTO{" +
                "coursename='" + coursename + '\'' +
                '}';
    }

    // equals and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseSaveDTO that = (CourseSaveDTO) o;

        return coursename != null ? coursename.equals(that.coursename) : that.coursename == null;
    }

    @Override
    public int hashCode() {
        return coursename != null ? coursename.hashCode() : 0;
    }
}