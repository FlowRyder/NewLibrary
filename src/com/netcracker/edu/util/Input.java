package com.netcracker.edu.util;

import java.util.Calendar;
import java.util.Scanner;

/**
 * Created by FlowRyder on 29.11.2015.
 */
public class Input {
    public static Calendar readDate(int day, int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.YEAR, year);
        return calendar;
    }

    public static String writeCalendar(Calendar calendar) {
        return calendar.get(Calendar.DAY_OF_MONTH) + " " + calendar.get(Calendar.MONTH) + " " + calendar.get(Calendar.YEAR);
    }

    public static Calendar loadCalendar(String[] parameters) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(parameters[0]));
        calendar.set(Calendar.MONTH, Integer.parseInt(parameters[1]));
        calendar.set(Calendar.YEAR, Integer.parseInt(parameters[2]));
        return calendar;
    }
}
