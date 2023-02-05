
package model;

import java.util.ArrayList;

public class Student {

    private int id;
    private String name;
    private String batch;
    private String fatherName;
    private String motherName;
    private String contactNo;
    private String email;
    private String qualification;
    private String parentContactNo;
    private String address;
    private String gender;
    private ArrayList AttendenceList;

    public Student(int id, String name, String batch, String fatherName, String motherName, String contactNo, String email, String qualification, String parentContactNo, String address, String gender) {
        this.id = id;
        this.name = name;
        this.batch = batch;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.contactNo = contactNo;
        this.email = email;
        this.qualification = qualification;
        this.parentContactNo = parentContactNo;
        this.address = address;
        this.gender = gender;
    }

    
    public Student(int id, String name, String batch, String fatherName, String motherName, String contactNo, String email, String qualification, String parentContactNo, String address, String gender, ArrayList AttendenceList) {
        this.id = id;
        this.name = name;
        this.batch = batch;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.contactNo = contactNo;
        this.email = email;
        this.qualification = qualification;
        this.parentContactNo = parentContactNo;
        this.address = address;
        this.gender = gender;
        this.AttendenceList = AttendenceList;
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

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getParentContactNo() {
        return parentContactNo;
    }

    public void setParentContactNo(String parentContactNo) {
        this.parentContactNo = parentContactNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ArrayList getAttendenceList() {
        return AttendenceList;
    }

    public void setAttendenceList(ArrayList AttendenceList) {
        this.AttendenceList = AttendenceList;
    }

}
