package com.group.a.gradeapp.DB.TypeConverter;

import java.util.Date;
import androidx.room.TypeConverter;


public class DateTypeConverter {
    @TypeConverter
    public long convertDateToLong(Date date){
        return date.getTime();
    }
    @TypeConverter
    public Date convertLongToDate(long time){
        return new Date(time);
    }

}
