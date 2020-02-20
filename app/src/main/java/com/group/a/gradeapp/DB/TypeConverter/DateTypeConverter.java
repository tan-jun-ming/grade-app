package com.group.a.gradeapp.DB.TypeConverter;

import java.util.Calendar;
import java.util.Date;
import androidx.room.TypeConverter;


public class DateTypeConverter {
    /**
     * Converts a Calendar object to a long
     *
     * @param c The calendar object
     * @return The long
     */
    @TypeConverter
    public static long convertDateToLong(Calendar c){
        return c.getTimeInMillis();
    }

    /**
     * Converts a long to a Calendar object
     *
     * @param time The long
     * @return The calendar object
     */
    @TypeConverter
    public static Calendar convertLongToDate(long time){
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(time);
        return c;
    }

}
