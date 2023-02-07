/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Attendence;
import services.GetConnection;

/**
 *
 * @author ftt
 */
public class AttendenceDao {

    public static ArrayList<Attendence> getAttendenceById(String id) {

        ArrayList<Attendence> al = new ArrayList<Attendence>();
        Connection con = null;

        try {
            con = GetConnection.getConnection();
            String sql = "select * from attendence where stdId = " + id + "";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String date = rs.getString("date");
                String time = rs.getString("time");
                Attendence a = new Attendence(id, date, time);
                al.add(a);
            }
        } catch (Exception e) {
            System.out.println("e" + e);
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return al;
    }

    public static ArrayList<Attendence> getAllAttendence() {

        ArrayList<Attendence> al = new ArrayList<Attendence>();
        Connection con = null;

        try {
            con = GetConnection.getConnection();
            String sql = "select * from attendence";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("stdId");
                String date = rs.getString("date");
                String time = rs.getString("time");
                Attendence a = new Attendence("" + id, date, time);
                al.add(a);
            }
        } catch (Exception e) {
            System.out.println("e" + e);
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return al;
    }

    public static ArrayList<Attendence> getAllAttendenceByDate(String d) {

        ArrayList<Attendence> al = new ArrayList<Attendence>();
        Connection con = null;

        try {
            con = GetConnection.getConnection();
            String sql = "select * from attendence where date ='" + d + "'";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("stdId");
                String date = rs.getString("date");
                String time = rs.getString("time");
                Attendence a = new Attendence("" + id, date, time);
                al.add(a);
            }
        } catch (Exception e) {
            System.out.println("e" + e);
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return al;
    }

    public static ArrayList<Attendence> getAttendenceByDateAndId(int id, String date) {
        ArrayList<Attendence> al = new ArrayList<Attendence>();
        Connection con = null;

        try {
            con = GetConnection.getConnection();
            String sql = "select * from attendence where stdId = " + id + " AND date='" + date + "'";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                String time = rs.getString("time");
                Attendence a = new Attendence("" + id, date, time);
                al.add(a);
            }
        } catch (Exception e) {
            System.out.println("e" + e);
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return al;
    }
}
