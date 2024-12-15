package com.lbs.Studentmanagementapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id", length = 11)
    private int studentId; // Alan adı düzenlendi

    @Column(name = "student_name", length = 45)
    private String studentName;

    @Column(name = "address", length = 60)
    private String address;

    @Column(name = "phone", length = 12)
    private String phone;

    // Parametresiz constructor
    public Student() {
    }

    // Tüm alanları alan constructor
    public Student(int studentId, String studentName, String address, String phone) {
        this.studentId = studentId; // Düzgün alan adı kullanımı
        this.studentName = studentName;
        this.address = address;
        this.phone = phone;
    }

    // Öğrenci adı, adres ve telefon alanlarını alan constructor
    public Student(String studentName, String address, String phone) {
        this.studentName = studentName;
        this.address = address;
        this.phone = phone;
    }

    // Getter ve Setter metodları
    public int getStudentId() { // Düzgün getter
        return studentId;
    }

    public void setStudentId(int studentId) { // Düzgün setter
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // toString metodu
    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId + // Düzenlendi
                ", studentName='" + studentName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}