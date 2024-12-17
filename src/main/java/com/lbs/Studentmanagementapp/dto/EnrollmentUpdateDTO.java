package com.lbs.Studentmanagementapp.dto;

public class EnrollmentUpdateDTO {

    private int enrollid;
    private int student_id;
    private int batch_id;
    private String joindate;
    private int fee;

    // Parametreli constructor
    public EnrollmentUpdateDTO(int enrollid, int student_id, int batch_id, String joindate, int fee) {
        this.enrollid = enrollid;
        this.student_id = student_id;
        this.batch_id = batch_id;
        this.joindate = joindate;
        this.fee = fee;
    }

    // Parametresiz constructor
    public EnrollmentUpdateDTO() {
    }

    // Getter ve Setter metodları
    public int getEnrollid() {
        return enrollid;
    }

    public void setEnrollid(int enrollid) {
        this.enrollid = enrollid;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(int batch_id) {
        this.batch_id = batch_id;
    }

    public String getJoindate() {
        return joindate;
    }

    public void setJoindate(String joindate) {
        this.joindate = joindate;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    // toString metodu
    @Override
    public String toString() {
        return "EnrollmentUpdateDTO{" +
                "enrollid=" + enrollid +
                ", student_id=" + student_id +
                ", batch_id=" + batch_id +
                ", joindate='" + joindate + '\'' +
                ", fee=" + fee +
                '}';
    }
}

