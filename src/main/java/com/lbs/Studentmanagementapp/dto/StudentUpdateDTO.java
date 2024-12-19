package com.lbs.Studentmanagementapp.dto;

public class StudentUpdateDTO {
    private int studentId;   // Öğrenci ID
    private String studentName;  // Öğrenci adı
    private String address;   // Adres
    private String phone;     // Telefon numarası


    public StudentUpdateDTO() {
    }


    public StudentUpdateDTO(int studentId, String studentName, String address, String phone) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.address = address;
        this.phone = phone;
    }

    // Getter ve Setter metodları
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
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
        return "StudentUpdateDTO{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}