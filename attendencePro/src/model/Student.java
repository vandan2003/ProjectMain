/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author ftt
 */
public class Student {
    private int id;
    private String name;
    private String batch;
    private ArrayList AttendenceList;
    private String qualification;
    private String address;
    private String email;
    private String contactNo;

   public Student(int id, String name, String batch, ArrayList AttendenceList, String qualification, String address, String email, String contactNo) {
        this.id = id;
        this.name = name;
        this.batch = batch;
        this.AttendenceList = AttendenceList;
        this.qualification = qualification;
        this.address = address;
        this.email = email;
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public ArrayList getAttendenceList() {
        return AttendenceList;
    }

    public void setAttendenceList(ArrayList AttendenceList) {
        this.AttendenceList = AttendenceList;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
}
