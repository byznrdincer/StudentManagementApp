package com.lbs.Studentmanagementapp.dto;

public class BatchUpdateDTO {

    private int batchid;
    private String batchname;
    private int courseid;
    private String startdate;

    // Parametreli constructor
    public BatchUpdateDTO(int batchid, String batchname, int courseid, String startdate) {
        this.batchid = batchid;
        this.batchname = batchname;
        this.courseid = courseid;
        this.startdate = startdate;
    }

    // Parametresiz constructor
    public BatchUpdateDTO() {
    }

    // Getter ve Setter metodları
    public int getBatchid() {
        return batchid;
    }

    public void setBatchid(int batchid) {
        this.batchid = batchid;
    }

    public String getBatchname() {
        return batchname;
    }

    public void setBatchname(String batchname) {
        this.batchname = batchname;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    // toString metodu
    @Override
    public String toString() {
        return "BatchUpdateDTO{" +
                "batchid=" + batchid +
                ", batchname='" + batchname + '\'' +
                ", courseid=" + courseid +
                ", startdate='" + startdate + '\'' +
                '}';
    }
}

