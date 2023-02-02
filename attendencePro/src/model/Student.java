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

    public Student(int id, String name, String batch, ArrayList AttendenceList, String qualification, String address) {
        this.id = id;
        this.name = name;
        this.batch = batch;
        this.AttendenceList = AttendenceList;
        this.qualification = qualification;
        this.address = address;
    }
}
