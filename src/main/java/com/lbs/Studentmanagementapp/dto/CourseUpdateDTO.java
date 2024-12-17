package com.lbs.Studentmanagementapp.dto;

public class CourseUpdateDTO {

    private int courseid;
    private String coursename;

    // No-argument constructor
    public CourseUpdateDTO() {
    }

    // All-argument constructor
    public CourseUpdateDTO(int courseid, String coursename) {
        this.courseid = courseid;
        this.coursename = coursename;
    }

    // Getters and Setters
    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    // toString method
    @Override
    public String toString() {
        return "CourseUpdateDTO{" +
                "courseid=" + courseid +
                ", coursename='" + coursename + '\'' +
                '}';
    }

    // equals and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseUpdateDTO that = (CourseUpdateDTO) o;

        if (courseid != that.courseid) return false;
        return coursename != null ? coursename.equals(that.coursename) : that.coursename == null;
    }

    @Override
    public int hashCode() {
        int result = courseid;
        result = 31 * result + (coursename != null ? coursename.hashCode() : 0);
        return result;
    }
}