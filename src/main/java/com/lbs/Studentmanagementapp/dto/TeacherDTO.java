package com.lbs.Studentmanagementapp.dto;

public class TeacherDTO {

    private int teacherid;
    private String teachername;
    private String address;
    private String phone;

    // Parametresiz Constructor
    public TeacherDTO() {
    }

    // Parametreli Constructor
    public TeacherDTO(int teacherid, String teachername, String address, String phone) {
        this.teacherid = teacherid;
        this.teachername = teachername;
        this.address = address;
        this.phone = phone;
    }

    // Getter ve Setter Metodları
    public int getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(int teacherid) {
        this.teacherid = teacherid;
    }

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
        return "TeacherDTO{" +
                "teacherid=" + teacherid +
                ", teachername='" + teachername + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

