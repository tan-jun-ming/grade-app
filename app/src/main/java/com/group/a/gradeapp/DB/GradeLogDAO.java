package com.group.a.gradeapp.DB;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


@Dao
public interface GradeLogDAO {

        @Insert
        void addGradeLog( Grade gradelog);

        @Update
        void update(Grade... grades);
        @Delete
        void delete(Grade grade);

        @Query("select * from " + AppDatabase.GRADELOG_TABLE)
        List<Grade> getGradeLogs();

//        @Query("SELECT * FROM " + AppDatabase.GRADELOG_TABLE + " WHERE gLogId = :logID")
//        Grade getGradeLogWithId(int logID);

//        @Query("select * from LogRecord order by time desc")
//        List<LogRecord> getAllLogRecords();

        @Query("select * from LogRecord order by time desc")
        List<LogRecord> getAllLogRecords();

        @Insert
        void addLogRecord(LogRecord rec);



}