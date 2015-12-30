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
}
