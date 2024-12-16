package com.lbs.Studentmanagementapp.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name="course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Eğer otomatik artan bir ID kullanıyorsanız
    @Column(name="course_id", length = 11)
    private int courseid;

    @Column(name="course_name", length = 45)
    private String coursename;

    @Column(name="syllabus", length = 60)
    private String syllabus;

    @Column(name="duration", length = 12)
    private String duration;

    @OneToMany(mappedBy = "course")
    private Set<Batch> batches;  // Set yerine List kullanılabilir

    public Course() {
    }

    public Course(String coursename, String syllabus, String duration) {
        this.coursename = coursename;
        this.syllabus = syllabus;
        this.duration = duration;
    }

    public Course(int courseid, String coursename, String syllabus, String duration) {
        this.courseid = courseid;
        this.coursename = coursename;
        this.syllabus = syllabus;
        this.duration = duration;
    }

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

    public Set<Batch> getBatches() {
        return batches;
    }

    public void setBatches(Set<Batch> batches) {
        this.batches = batches;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseid=" + courseid +
                ", coursename='" + coursename + '\'' +
                ", syllabus='" + syllabus + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}
