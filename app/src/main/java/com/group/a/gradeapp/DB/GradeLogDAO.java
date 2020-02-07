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
        void addGradeLog( GradeLog Gradelog);

        @Update
        void update(GradeLog... gradeLogs);
        @Delete
        void delete(GradeLog gradeLog);

        @Query("select * from " + AppDatabase.GRADELOG_TABLE)
        List<GradeLog> getGradeLogs();

//        @Query("SELECT * FROM " + AppDatabase.GRADELOG_TABLE + " WHERE gLogId = :logID")
//        GradeLog getGradeLogWithId(int logID);

//        @Query("select * from LogRecord order by time desc")
//        List<LogRecord> getAllLogRecords();





}