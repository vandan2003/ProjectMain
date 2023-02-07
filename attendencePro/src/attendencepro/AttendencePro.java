package attendencepro;

import dao.AttendenceDao;
import dao.StudentDao;
import java.util.ArrayList;
import model.*;

public class AttendencePro {
    public static void main(String[] args) {
       ArrayList total = null;
       ArrayList<AttendenceMain> attendenceMains;
       
       ArrayList<Student> students = StudentDao.getAllStudents();
       String date = "05/02/2023";
       for(Student st : students){
          ArrayList<Attendence> al = AttendenceDao.getAttendenceByDateAndId(st.getId(), date);
          String id = ""+st.getId();
          String inTime;
          String outTime;
          String duration;
          String totalBreakTime;
          String status;
          
          if(al.size() == 0){
              status = "Absent";
              inTime = "--:--";
              outTime = "--:--";
              totalBreakTime = "--:--";
              duration = "--:--";
          }
          else if(!TimeManager.checkHalfDay(TimeManager.getTotalInTime(al))){
              status = "HALF-DAY";
              inTime = al.get(0).getTime();
              outTime = al.get(al.size()-1).getTime();
              totalBreakTime = TimeManager.getTotalBreakTime(al);
              duration = TimeManager.getTotalInTime(al);
          }
          else{
              status = "Present";
              inTime = al.get(0).getTime();
              outTime = al.get(al.size()-1).getTime();
              totalBreakTime = TimeManager.getTotalBreakTime(al);
              duration = TimeManager.getTotalInTime(al);
          }
          
          AttendenceMain am = new AttendenceMain(id, inTime, outTime, duration, totalBreakTime, status);
        
           System.out.println(am.getStdId()+" "+am.getInTime()+" "+am.getOutTime()+" "+am.getDuration()+" "+am.getTotalBreakTime()+" "+ am.getStatus());
       }
       
//        ArrayList<Attendence> al = AttendenceDao.getAttendenceByDateAndId(35, "05/02/2023");
//          String id = ""+35;
//          String inTime;
//          String outTime;
//          String duration;
//          String totalBreakTime;
//          String status;
//          
//          if(al.size() == 0){
//              status = "Absent";
//              inTime = "--:--";
//              outTime = "--:--";
//              totalBreakTime = "--:--";
//              duration = "--:--";
//          }
//          else if(!TimeManager.checkHalfDay(TimeManager.getTotalInTime(al))){
//              status = "HALF-DAY";
//              inTime = al.get(0).getTime();
//              outTime = al.get(al.size()-1).getTime();
//              totalBreakTime = TimeManager.getTotalBreakTime(al);
//              duration = TimeManager.getTotalInTime(al);
//          }
//          else{
//              status = "Present";
//              inTime = al.get(0).getTime();
//              outTime = al.get(al.size()-1).getTime();
//              totalBreakTime = TimeManager.getTotalBreakTime(al);
//              duration = TimeManager.getTotalInTime(al);
//          }
//          
//          AttendenceMain am = new AttendenceMain(id, inTime, outTime, duration, totalBreakTime, status);
//          System.out.println(am.getStdId()+" "+am.getInTime()+" "+am.getOutTime()+" "+am.getDuration()+" "+am.getTotalBreakTime()+" "+ am.getStatus());
    }
}
