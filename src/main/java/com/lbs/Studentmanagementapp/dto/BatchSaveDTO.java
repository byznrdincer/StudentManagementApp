package com.lbs.Studentmanagementapp.dto;

public class BatchSaveDTO {

    private String batchname;
    private int courseid;
    private String startdate;

    // Parametreli constructor
    public BatchSaveDTO(String batchname, int courseid, String startdate) {
        this.batchname = batchname;
        this.courseid = courseid;
        this.startdate = startdate;
    }

    // Parametresiz constructor
    public BatchSaveDTO() {
    }

    // Getter ve Setter metodları
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
        return "BatchSaveDTO{" +
                "batchname='" + batchname + '\'' +
                ", courseid=" + courseid +
                ", startdate='" + startdate + '\'' +
                '}';
    }
}

