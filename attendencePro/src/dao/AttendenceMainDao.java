package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.*;

import java.util.ArrayList;
import model.Attendence;
import services.GetConnection;

public class AttendenceMainDao {

    public static boolean addMainAttendence(AttendenceMain a) {
        boolean status = false;
        Connection con = null;
        try {
            con = GetConnection.getConnection();
            String sql = " INSERT INTO attendencemain(stdId,inTime,outTime,duration,totalBreakTime,status) values (?,?,?,?,?,?);";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, a.getStdId());
            ps.setString(2, a.getInTime());
            ps.setString(3, a.getOutTime());
            ps.setString(4, a.getDuration());
            ps.setString(5, a.getTotalBreakTime());
            ps.setString(6, a.getStatus());

            if (ps.executeUpdate() != 0) {
                status = true;
            }

        } catch (Exception e) {
            System.out.println("" + e);
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return status;
    }

    public static ArrayList<AttendenceMain> getAllStudents() {
        Connection con = null;

        ArrayList<AttendenceMain> ats = new ArrayList<>();
        try {
            //jdbc code
            con = GetConnection.getConnection();
            String q = "select*from student";
            PreparedStatement pstmt = con.prepareStatement(q);
            ResultSet set = pstmt.executeQuery();
            while (set.next()) {
                String stdId = set.getString("id");

                String date = set.getString("date");

                String inTime = set.getString("inTime");

                String outTime = set.getString("outTime");

                String duration = set.getString("duration");

                String totalBreakTime = set.getString("totalBreakTime");

                String status = set.getString("status");

                AttendenceMain at = new AttendenceMain(stdId, date, inTime, outTime, duration, totalBreakTime, status);

                ats.add(at);

            }

        } catch (Exception e) {
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return ats;
    }

}
