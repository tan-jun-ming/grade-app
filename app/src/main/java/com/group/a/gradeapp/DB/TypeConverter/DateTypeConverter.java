package com.group.a.gradeapp.DB.TypeConverter;

import java.util.Calendar;
import java.util.Date;
import androidx.room.TypeConverter;


public class DateTypeConverter {
    @TypeConverter
    public long convertCalendarToLong(Calendar c){
        return c.getTimeInMillis();
    }
    @TypeConverter
    public Calendar convertLongToCalendar(long time){
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(time);
        return c;
    }

}
