package Dao;

import model.Student;
import model.Attendence;
import services.GetConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentDao {

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
                Attendence a = new Attendence(""+id, date, time);
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
            String sql = "select * from attendence where date ='"+d+"'";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("stdId");
                String date = rs.getString("date");
                String time = rs.getString("time");
                Attendence a = new Attendence(""+id, date, time);
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

    
    public static boolean addStudent(Student s) {
        boolean status = false;
        Connection con = null;
        try {
            con = GetConnection.getConnection();
            String sql = " INSERT INTO student(name,batch,qualification,address,gender,email,contactNo) values (?,?,?,?,?,?,?);";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, s.getName());
            ps.setString(2, s.getBatch());
            ps.setString(3, s.getQualification());
            ps.setString(4, s.getAddress());
            ps.setString(5, s.getGender());
            ps.setString(6, s.getEmail());
            ps.setString(7, s.getContactNo());

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

//    ----------------------------------------------------------------------
    public static ArrayList<Student> getAllStudents() {
        Connection con = null;

        ArrayList<Student> students = new ArrayList<>();
        try {
            //jdbc code
            con = GetConnection.getConnection();
            String q = "select*from student";
            PreparedStatement pstmt = con.prepareStatement(q);
            ResultSet set = pstmt.executeQuery();
            while (set.next()) {
                int stdId = set.getInt("id");

                String name = set.getString("name");

                String batch = set.getString("batch");

                String fname = set.getString("fatherName");

                String mname = set.getString("motherName");

                String qualifi = set.getString("qualification");

                String address = set.getString("address");

                String gender = set.getString("gender");

                String email = set.getString("email");

                String contactNo = set.getString("contactNo");

                Student std = new Student(stdId, name, batch, fname, mname, contactNo, email, qualifi, contactNo, address, gender);

                students.add(std);

            }

        } catch (Exception e) {
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return students;
    }

    public static Student getStudent(int id) {
        Connection con = null;
        Student std = null;
        
        try {
            //jdbc code
            con = GetConnection.getConnection();
            String q = "select*from student where id=?";
            PreparedStatement pstmt = con.prepareStatement(q);
            ResultSet set = pstmt.executeQuery();
            while (set.next()) {
                int stdId = set.getInt("id");

                String name = set.getString("name");

                String batch = set.getString("batch");

                String fname = set.getString("fatherName");

                String mname = set.getString("motherName");

                String qualifi = set.getString("qualification");

                String address = set.getString("address");

                String gender = set.getString("gender");

                String email = set.getString("email");

                String contactNo = set.getString("contactNo");

                std = new Student(stdId, name, batch, fname, mname, contactNo, email, qualifi, contactNo, address, gender);

            }

        } catch (Exception e) {
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return std;
    }

    public static ArrayList<Student> getStudentsByBatch(String batch) {
        Connection con = null;

        ArrayList<Student> students = new ArrayList<>();
        try {
            //jdbc code
            con = GetConnection.getConnection();
            String q = "select*from student where batch='"+batch+"'";
            PreparedStatement pstmt = con.prepareStatement(q);
            ResultSet set = pstmt.executeQuery();
            while (set.next()) {
                int stdId = set.getInt("id");

                String name = set.getString("name");

                String batchnew = set.getString("batch");

                String fname = set.getString("fatherName");

                String mname = set.getString("motherName");

                String qualifi = set.getString("qualification");

                String address = set.getString("address");

                String gender = set.getString("gender");

                String email = set.getString("email");

                String contactNo = set.getString("contactNo");

                Student std = new Student(stdId, name, batchnew, fname, mname, contactNo, email, qualifi, contactNo, address, gender, students);

                students.add(std);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return students;
    }
    
    public static ArrayList<Attendence> getAttendenceByDateAndId(int id,String date) {
         ArrayList<Attendence> al = new ArrayList<Attendence>();
        Connection con = null;

        try {
            con = GetConnection.getConnection();
            String sql = "select * from attendence where stdId = " + id + " AND date='"+date+"'";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                
                String time = rs.getString("time");
                Attendence a = new Attendence(""+id, date, time);
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

    public static void main(String[] args) {

        ArrayList<Attendence> a;
       a =getAllAttendenceByDate("01/02/2023");
        if(a==null)
            System.out.println("Null");
        else
            for(Attendence data : a)
                System.out.println("id : " +data.getStdId()+" Date : "+data.getDate()+" Time : "+data.getTime());
    }

}
