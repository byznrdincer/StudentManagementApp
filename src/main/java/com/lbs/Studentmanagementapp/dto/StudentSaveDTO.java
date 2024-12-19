package com.lbs.Studentmanagementapp.dto;

public class StudentSaveDTO {

    private String studentName;
    private String address;
    private String phone;

    // Parametresiz Constructor
    public StudentSaveDTO() {
    }

    // Parametreli Constructor
    public StudentSaveDTO(String studentName, String address, String phone) {
        this.studentName = studentName;
        this.address = address;
        this.phone = phone;
    }

    // Getter ve Setter Metodları
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

    // toString Metodu
    @Override
    public String toString() {
        return "StudentSaveDTO{" +
                "studentName='" + studentName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

