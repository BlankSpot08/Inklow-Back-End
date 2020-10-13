package com.example.inklow.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateUtil {
    public DateUtil(Date date) { }

    public static Date toDateFromISODateString(String date) {
        Date tempDate = null;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        try {
            tempDate = simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return tempDate;
    }

    public static String toISOStringFromDate(Date date) {
        String tempString = null;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        tempString = simpleDateFormat.format(date);

        return tempString;
    }
}
