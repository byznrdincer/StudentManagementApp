package com.lbs.Studentmanagementapp.dto;

import com.lbs.Studentmanagementapp.entity.Batch;
import com.lbs.Studentmanagementapp.entity.Student;

public class EnrollmentDTO {

    private int enrollid;
    private int studentId;
    private String studentName;
    private int batchId;
    private String batchName;
    private String joindate;
    private int fee;

    // Parametreli constructor
    public EnrollmentDTO(int enrollid, int studentId, String studentName, int batchId, String batchName, String joindate, int fee) {
        this.enrollid = enrollid;
        this.studentId = studentId;
        this.studentName = studentName;
        this.batchId = batchId;
        this.batchName = batchName;
        this.joindate = joindate;
        this.fee = fee;
    }

    // Parametresiz constructor
    public EnrollmentDTO(int enrollid, Student student, Batch batch, String joindate, int fee) {
        this.enrollid = enrollid;
        this.studentId = student.getStudentId();
        this.studentName = student.getStudentName();
        this.batchId = batch.getBatchid();
        this.batchName = batch.getBatchname();
        this.joindate = joindate;
        this.fee = fee;
    }

    // Getter ve Setter metodları
    public int getEnrollid() {
        return enrollid;
    }

    public void setEnrollid(int enrollid) {
        this.enrollid = enrollid;
    }

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

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
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
        return "EnrollmentDTO{" +
                "enrollid=" + enrollid +
                ", studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", batchId=" + batchId +
                ", batchName='" + batchName + '\'' +
                ", joindate='" + joindate + '\'' +
                ", fee=" + fee +
                '}';
    }
}
