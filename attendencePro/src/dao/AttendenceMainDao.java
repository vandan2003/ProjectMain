
package dao;

import java.util.ArrayList;
import model.Attendence;


public class AttendenceMainDao {
     public static String getTotalBreakTime(ArrayList<Attendence> al){
      String totalBreakTime = "00:00";
        for(int i=1;i<al.size()-1;i++){
            String dif = getDifferenceBtwTimes(al.get(i).getTime(), al.get(i+1).getTime());
            totalBreakTime = getAdditionBtwTimes(totalBreakTime, dif);
            i++;
        }
       return totalBreakTime;
    }
    
    public static String getTotalInTime(ArrayList<Attendence> al){
       String totalTime = getDifferenceBtwTimes(al.get(0).getTime(), al.get(al.size()-1).getTime());
        String totalBreakTime = getTotalBreakTime(al);
        totalTime = getDifferenceBtwTimes(totalBreakTime, totalTime);
       return totalTime;
    }
    
    public static String getDifferenceBtwTimes(String time1,String time2){
      String arr1[] = time1.split(":");
        String arr2[] = time2.split(":");

        int entryHour = Integer.parseInt(arr1[0]);
        int exitHour = Integer.parseInt(arr2[0]);
        
        int entryMin = Integer.parseInt(arr1[1]);
        int exitMin = Integer.parseInt(arr2[1]);
        
        if(exitMin < entryMin){
           exitMin=exitMin+60;
           exitHour--;
        }
        
        int totalMin = exitMin - entryMin;
        

        int totalHour = exitHour - entryHour;
        
        if(totalMin >= 60){
           totalMin = totalMin-60;
           totalHour++;
        }
      return totalHour+":"+totalMin;
    }
    
    public static String getAdditionBtwTimes(String time1,String time2){
        String arr1[] = time1.split(":");
        String arr2[] = time2.split(":");

        int entryHour = Integer.parseInt(arr1[0]);
        int exitHour = Integer.parseInt(arr2[0]);
        
        int entryMin = Integer.parseInt(arr1[1]);
        int exitMin = Integer.parseInt(arr2[1]);
        
        if(exitMin < entryMin){
           exitMin=exitMin+60;
           exitHour--;
        }
        
        int totalMin = exitMin + entryMin;
        

        int totalHour = exitHour - entryHour;
        
        if(totalMin >= 60){
           totalMin = totalMin-60;
           totalHour++;
        }
      return totalHour+":"+totalMin;
    }
}