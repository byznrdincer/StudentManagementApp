package com.lbs.Studentmanagementapp.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Eğer otomatik artan bir ID kullanıyorsanız
    @Column(name = "course_id", length = 11)
    private int courseid;

    @Column(name = "course_name", length = 45)
    private String coursename;

    @OneToMany(mappedBy = "course")
    private Set<Batch> batches; // Set yerine List kullanılabilir

    public Course() {
    }

    public Course(String coursename) {
        this.coursename = coursename;
    }

    public Course(int courseid, String coursename) {
        this.courseid = courseid;
        this.coursename = coursename;
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
                '}';
    }
}