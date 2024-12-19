package com.lbs.Studentmanagementapp.dto;

public class CourseSaveDTO {

    private String coursename;
    private String syllabus;
    private String duration;

    // No-argument constructor
    public CourseSaveDTO() {
    }

    // All-argument constructor
    public CourseSaveDTO(String coursename, String syllabus, String duration) {
        this.coursename = coursename;
        this.syllabus = syllabus;
        this.duration = duration;
    }

    // Getters and Setters
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
        return "CourseSaveDTO{" +
                "coursename='" + coursename + '\'' +
                ", syllabus='" + syllabus + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }

    // equals and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseSaveDTO that = (CourseSaveDTO) o;

        if (coursename != null ? !coursename.equals(that.coursename) : that.coursename != null) return false;
        if (syllabus != null ? !syllabus.equals(that.syllabus) : that.syllabus != null) return false;
        return duration != null ? duration.equals(that.duration) : that.duration == null;
    }

    @Override
    public int hashCode() {
        int result = coursename != null ? coursename.hashCode() : 0;
        result = 31 * result + (syllabus != null ? syllabus.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        return result;
    }
}

