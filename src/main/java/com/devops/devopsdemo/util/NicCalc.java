package com.devops.devopsdemo.util;

import com.devops.devopsdemo.controller.StudentController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class NicCalc {

    private static final Logger logger = LoggerFactory.getLogger(NicCalc.class);

    static String year, month, date, gender = "Male";
    static int datesOfMonth[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    public static Map<String, String> getDobAndGender(String idNumber) {
        Map<String, String> map = new HashMap<>();
        if (idNumber.length() == 10){
            oldNIC(idNumber);
        }else if (idNumber.length() == 12){
            newNIC(idNumber);
        }else {
            logger.error("Enter a valid ID number.\nEx :- 970000000V or 199700000000");
        }
        map.put("dob", year + " " + month + " " + date);
        map.put("gender", gender);
        return map;
    }

    private static void oldNIC(String idNumber) {
        year = "19" + idNumber.substring(0, 2);
        int day = Integer.parseInt(idNumber.substring(2, 5));
        if(day > 500){
            day -= 500;
            gender = "Female";
        }
        int total = 0;
        for(int i = 0; i < datesOfMonth.length; i++){
            total += datesOfMonth[i];
            if(day <= total){
                month = months[i];
                date = Integer.toString(day - (total - datesOfMonth[i]));
                break;
            }
        }
    }

    private static void newNIC(String idNumber) {
        year = idNumber.substring(0, 4);
        int day = Integer.parseInt(idNumber.substring(4, 7));
        if(day > 500){
            day -= 500;
            gender = "Female";
        }
        int total = 0;
        for(int i = 0; i < datesOfMonth.length; i++){
            total += datesOfMonth[i];
            if(day <= total){
                month = months[i];
                date = Integer.toString(day - (total - datesOfMonth[i]));
                break;
            }
        }
    }
}
