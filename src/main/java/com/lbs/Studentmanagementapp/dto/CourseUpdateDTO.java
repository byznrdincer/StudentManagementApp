package com.lbs.Studentmanagementapp.dto;

public class CourseUpdateDTO {

    private int courseid;
    private String coursename;
    private String syllabus;
    private String duration;

    // No-argument constructor
    public CourseUpdateDTO() {
    }

    // All-argument constructor
    public CourseUpdateDTO(int courseid, String coursename, String syllabus, String duration) {
        this.courseid = courseid;
        this.coursename = coursename;
        this.syllabus = syllabus;
        this.duration = duration;
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

    public String getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(String syllabus) {
        this.syllabus = syllabus;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    // toString method
    @Override
    public String toString() {
        return "CourseUpdateDTO{" +
                "courseid=" + courseid +
                ", coursename='" + coursename + '\'' +
                ", syllabus='" + syllabus + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }

    // equals and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseUpdateDTO that = (CourseUpdateDTO) o;

        if (courseid != that.courseid) return false;
        if (coursename != null ? !coursename.equals(that.coursename) : that.coursename != null) return false;
        if (syllabus != null ? !syllabus.equals(that.syllabus) : that.syllabus != null) return false;
        return duration != null ? duration.equals(that.duration) : that.duration == null;
    }

    @Override
    public int hashCode() {
        int result = courseid;
        result = 31 * result + (coursename != null ? coursename.hashCode() : 0);
        result = 31 * result + (syllabus != null ? syllabus.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        return result;
    }
}

