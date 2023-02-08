/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ftt
 */
public class AttendenceMain {
    private String stdId;
    private String name;
    private String date;
    private String inTime;
    private String outTime;
    private String duration;
    private String totalBreakTime;
    private String status;

    public AttendenceMain(String stdId, String date, String inTime, String outTime, String duration, String totalBreakTime, String status) {
        this.stdId = stdId;
        this.date = date;
        this.inTime = inTime;
        this.outTime = outTime;
        this.duration = duration;
        this.totalBreakTime = totalBreakTime;
        this.status = status;
    }

    public AttendenceMain(String stdId, String name, String date, String inTime, String outTime, String duration, String totalBreakTime, String status) {
        this.stdId = stdId;
        this.name = name;
        this.date = date;
        this.inTime = inTime;
        this.outTime = outTime;
        this.duration = duration;
        this.totalBreakTime = totalBreakTime;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public String getStdId() {
        return stdId;
    }

    public void setStdId(String stdId) {
        this.stdId = stdId;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getTotalBreakTime() {
        return totalBreakTime;
    }

    public void setTotalBreakTime(String totalBreakTime) {
        this.totalBreakTime = totalBreakTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
 
    
}
