/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package attendencepro;

import dao.AttendenceDao;
import dao.StudentDao;
import java.util.ArrayList;
import model.Attendence;
import model.AttendenceMain;
import model.Student;

/**
 *
 * @author ftt
 */
public class TimeManager {

    public static String getTotalBreakTime(ArrayList<Attendence> al) {
        String totalBreakTime = "00:00";
        for (int i = 1; i < al.size() - 1; i++) {
            String dif = getDifferenceBtwTimes(al.get(i).getTime(), al.get(i + 1).getTime());
            totalBreakTime = getAdditionBtwTimes(totalBreakTime, dif);
            i++;
        }
        return totalBreakTime;
    }

    public static String getTotalInTime(ArrayList<Attendence> al) {
        String totalTime = getDifferenceBtwTimes(al.get(0).getTime(), al.get(al.size() - 1).getTime());
        String totalBreakTime = getTotalBreakTime(al);
        totalTime = getDifferenceBtwTimes(totalBreakTime, totalTime);
        return totalTime;
    }

    public static String getDifferenceBtwTimes(String time1, String time2) {
        String arr1[] = time1.split(":");
        String arr2[] = time2.split(":");

        int entryHour = Integer.parseInt(arr1[0]);
        int exitHour = Integer.parseInt(arr2[0]);

        int entryMin = Integer.parseInt(arr1[1]);
        int exitMin = Integer.parseInt(arr2[1]);

        if (exitMin < entryMin) {
            exitMin = exitMin + 60;
            exitHour--;
        }

        int totalMin = exitMin - entryMin;

        int totalHour = exitHour - entryHour;

        if (totalMin >= 60) {
            totalMin = totalMin - 60;
            totalHour++;
        }
        return totalHour + ":" + totalMin;
    }

    public static String getAdditionBtwTimes(String time1, String time2) {
   
        String arr1[] = time1.split(":");
        String arr2[] = time2.split(":");

        int entryHour = Integer.parseInt(arr1[0]);
        int exitHour = Integer.parseInt(arr2[0]);

        int entryMin = Integer.parseInt(arr1[1]);
        int exitMin = Integer.parseInt(arr2[1]);


        int totalMin = exitMin + entryMin;

        int totalHour = exitHour + entryHour;
      

        if (totalMin >= 60) {
            totalMin = totalMin - 60;
            totalHour++;
        }
        return totalHour + ":" + totalMin;
    }

    public static boolean checkHalfDay(String totalTime) {
        String marginTime = "7:15";

        String arr1[] = totalTime.split(":");
        String arr2[] = marginTime.split(":");

        int tbtHour = Integer.parseInt(arr1[0]);
        int mHour = Integer.parseInt(arr2[0]);

        int tbtMin = Integer.parseInt(arr1[1]);
        int mMin = Integer.parseInt(arr2[1]);

        if (tbtHour < mHour) {
            return false;
        } else if (tbtHour > mHour) {
            return true;
        } else if (tbtHour == mHour && tbtMin >= mMin) {
            return true;
        }

        return false;
    }
    
    public static ArrayList<AttendenceMain> getAttendenceByDate(String date){
      ArrayList<AttendenceMain> attendenceMains = new ArrayList<AttendenceMain>();
       
       ArrayList<Student> students = StudentDao.getAllStudents();
      
       for(Student st : students){
          ArrayList<Attendence> al = AttendenceDao.getAttendenceByDateAndId(st.getId(), date);
          String id = ""+st.getId();
          String inTime;
          String outTime;
          String duration;
          String totalBreakTime;
          String status;
          
          if(al.size() == 0){
              status = "ABSENT";
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
              status = "PRESENT";
              inTime = al.get(0).getTime();
              outTime = al.get(al.size()-1).getTime();
              totalBreakTime = TimeManager.getTotalBreakTime(al);
              duration = TimeManager.getTotalInTime(al);
          }
          
          AttendenceMain am = new AttendenceMain(id,st.getName(),date, inTime, outTime, duration, totalBreakTime, status);
          attendenceMains.add(am);
//          System.out.println(am.getStdId()+" "+st.getName()+" "+am.getDate()+" "+am.getInTime()+" "+am.getOutTime()+" "+am.getDuration()+" "+am.getTotalBreakTime()+" "+ am.getStatus());
       }
       return attendenceMains;
    }
}
