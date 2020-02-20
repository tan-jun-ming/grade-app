package com.group.a.gradeapp.DB.TypeConverter;

import java.util.Calendar;
import java.util.Date;
import androidx.room.TypeConverter;


public class DateTypeConverter {
    @TypeConverter
    public static long convertDateToLong(Calendar c){
        return c.getTimeInMillis();
    }
    @TypeConverter
    public static Calendar convertLongToDate(long time){
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(time);
        return c;
    }

}
