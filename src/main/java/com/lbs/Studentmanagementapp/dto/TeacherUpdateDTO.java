package com.lbs.Studentmanagementapp.dto;
public class TeacherUpdateDTO {
    private int teacherid;
    private String teachername;
    private String address;
    private String phone;

    // Parametresiz constructor
    public TeacherUpdateDTO() {
    }

    // Parametreli constructor
    public TeacherUpdateDTO(int teacherid, String teachername, String address, String phone) {
        this.teacherid = teacherid;
        this.teachername = teachername;
        this.address = address;
        this.phone = phone;
    }

    // Getter ve Setter metodları
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
}
