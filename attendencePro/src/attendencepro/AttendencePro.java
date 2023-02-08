package attendencepro;

import dao.AttendenceDao;
import dao.StudentDao;
import java.util.ArrayList;
import model.*;

public class AttendencePro {

    public static void main(String[] args) {
        ArrayList<AttendenceMain> al = TimeManager.getAttendenceByDate("05/02/2023");
        System.out.printf("%-10s%-23s%-15s%-10s%-10s%-10s%-10s%-10s\n\n", "STD ID", "NAME", "DATE", "IN TIME", "OUT TIME", "TOTAL IN TIME", "TOTAL BREAK TIME", "STATUS");

        for (AttendenceMain a : al) {
            System.out.printf("%-10s%-23s%-15s%-10s%-10s%-10s%-10s%-10s\n", a.getStdId(), a.getName(), a.getDate(), a.getInTime(), a.getOutTime(), a.getDuration(), a.getTotalBreakTime(), a.getStatus());
        }

    }
}
