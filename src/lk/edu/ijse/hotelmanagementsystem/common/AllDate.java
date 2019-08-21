package lk.edu.ijse.hotelmanagementsystem.common;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author USER
 */

public class AllDate {

    /**
     *
     */
    public static String days1 = "";
    public static String days2 = "";
    public static String month1 = "";
    public static String month2 = "";
    public static String monthDifference = "";

    /**
     * @param args the command line arguments
     */
    
    /**
     *
     * @param date1
     * @param date2
     * @return
     */
    public static ArrayList<String> getAllDatesInTheRange(String date1, String date2) {
        ArrayList<String> data = new ArrayList<>();
        String newDate1 = date1;
        String newDate2 = date2;
        String[] split = newDate1.split("/");
        String[] split1 = newDate2.split("/");
        ArrayList<String> al = new ArrayList<>();
        ArrayList<String> a2 = new ArrayList<>();
        //ArrayList<String> a3 = new ArrayList<>();
        al.addAll(Arrays.asList(split));
        a2.addAll(Arrays.asList(split1));
        month1 = al.get(1);
        month2 = a2.get(1);
        String difference = Integer.toString(Integer.parseInt(a2.get(1)) - Integer.parseInt(al.get(1)));
        monthDifference = difference;
        String dayCount = getDayCount(al.get(1));
        String dayCount2 = getDayCount(a2.get(1));
        days1 = dayCount;
        days2 = dayCount2;
        int day = Integer.parseInt(al.get(2));
        int day4 = Integer.parseInt(a2.get(2));
        int day7 = day;
        int day5 = 0;
        int day8 = 0;
        int day3 = day;
        int day2 = Integer.parseInt(days1);
        int dayDif = day2 - day;
        ArrayList<String> a4 = new ArrayList<>();
        a4.add(date1);
        int parseInt = Integer.parseInt(month1);
        int parseInt1 = Integer.parseInt(month2);
        int newMonth = parseInt + 1;
        int monthDif = parseInt1 - parseInt;
        int dayCount3 = day4 - day;

        if (monthDif == 0) {
            for (int i = 0; i < dayCount3; i++) {
                day7 += 1;
                a4.add(al.get(0) + "/" + al.get(1) + "/" + (day7));
            }
        } else {
            for (int i = 0; i < dayDif; i++) {
                day3 += 1;
                a4.add(al.get(0) + "/" + al.get(1) + "/" + (day3));
            }
        }
        if (monthDif == 1) {
            for (int i = 0; i < day4; i++) {
                day5 += 1;
                a4.add(a2.get(0) + "/" + a2.get(1) + "/" + (day5));
            }
        }
        if (monthDif > 1) {
            for (int i = 0; i < monthDif - 1; i++) {
                int dayCount1 = Integer.parseInt(getDayCount("0" + Integer.toString(newMonth)));
                for (int j = 0; j < dayCount1; j++) {
                    day8 += 1;
                    String y = "";
                    int x = day8;
                    if (x < 9) {
                        y = "0" + day8;
                    } else {
                        y = Integer.toString(day8);
                    }
                    a4.add(al.get(0) + "/" + "0" + Integer.toString(newMonth) + "/" + y);
                }
                newMonth += 1;
            }
            for (int i = 0; i < day4; i++) {
                day5 += 1;
                String y = "";
                int x = day5;
                if (x < 9) {
                    y = "0" + day5;
                } else {
                    y = Integer.toString(day5);
                }
                a4.add(a2.get(0) + "/" + a2.get(1) + "/" + (y));
            }
        }
        data = a4;
        
        return data;
    }

    public static String getDayCount(String month) {
        String retVal = "";
        switch (month) {
            case "01":
                retVal = "31";
                break;
            case "02":
                retVal = "28";
                break;
            case "03":
                retVal = "31";
                break;
            case "04":
                retVal = "30";
                break;
            case "05":
                retVal = "31";
                break;
            case "06":
                retVal = "30";
                break;
            case "07":
                retVal = "31";
                break;
            case "08":
                retVal = "31";
                break;
            case "09":
                retVal = "30";
                break;
            case "10":
                retVal = "31";
                break;
            case "11":
                retVal = "30";
                break;
            case "12":
                retVal = "31";
        }
        return retVal;
    }

}
