package com.lbs.Studentmanagementapp.dto;

public class TeacherSaveDTO {

    private String teachername;
    private String address;
    private String phone;

    // Parametresiz Constructor
    public TeacherSaveDTO() {
    }

    // Parametreli Constructor
    public TeacherSaveDTO(String teachername, String address, String phone) {
        this.teachername = teachername;
        this.address = address;
        this.phone = phone;
    }

    // Getter ve Setter Metodları
    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
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
        return "TeacherSaveDTO{" +
                "teachername='" + teachername + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

