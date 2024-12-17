package com.lbs.Studentmanagementapp.dto;

import com.lbs.Studentmanagementapp.entity.Course;

public class BatchDTO {
    private int batchid;
    private String batchname;
    private CourseDTO course; // CourseDTO kullanılıyor
    private String startdate;

    // Parametreli constructor
    public BatchDTO(int batchid, String batchname, CourseDTO course, String startdate) {
        this.batchid = batchid;
        this.batchname = batchname;
        this.course = course;
        this.startdate = startdate;
    }

    // Parametresiz constructor
    public BatchDTO(int batchid, String batchname, Course course, String startdate) {
        this.batchid = batchid;
        this.batchname = batchname;
        // Course nesnesini CourseDTO'ya çevirme
        this.course = new CourseDTO(course.getCourseid(), course.getCoursename()); // course.getCoursename() gereksinimlerinize göre değişebilir
        this.startdate = startdate;
    }

    // Getter ve Setter metodları
    public int getBatchid() {
        return batchid;
    }

    public void setBatchid(int batchid) {
        this.batchid = batchid;
    }

    public String getBatchname() {
        return batchname;
    }

    public void setBatchname(String batchname) {
        this.batchname = batchname;
    }

    public CourseDTO getCourse() {
        return course;
    }

    public void setCourse(CourseDTO course) {
        this.course = course;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    // toString metodu
    @Override
    public String toString() {
        return "BatchDTO{" +
                "batchid=" + batchid +
                ", batchname='" + batchname + '\'' +
                ", course=" + course +
                ", startdate='" + startdate + '\'' +
                '}';
    }
}