package com.group.a.gradeapp.DB;


import androidx.room.Entity;
import androidx.room.RoomDatabase;
import androidx.room.Database;
import androidx.room.TypeConverters;
import com.group.a.gradeapp.DB.TypeConverter.DateTypeConverter;
import com.group.a.gradeapp.GradeLog;


@Database(entities = {User.class, GradeLog.class, LogRecord.class }, version =1)
@TypeConverters(DateTypeConverter.class)

@Entity

public abstract class AppDatabase extends RoomDatabase {
    public static final String dbName="db-gradelog";
    public static final String GRADELOG_TABLE="gradelog";
    public abstract GradeLogDAO getGradeLogDAO();
}

