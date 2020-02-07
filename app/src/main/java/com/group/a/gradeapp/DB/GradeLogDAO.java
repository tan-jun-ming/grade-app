package com.group.a.gradeapp.DB;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.group.a.gradeapp.GradeLog;

@Dao
public interface GradeLogDAO {

        @Insert
        void insert(GradeLog... gradeLogs);
        @Update
        void update(GradeLog... gradeLogs);
        @Delete
        void delete(GradeLog gradeLog);

        @Query("select * from User")
        List<User> getAllUsers();

        @Query("select * from User where username = :username")
        User getUserByName(String username);

        @Insert
        void addUser(User user);

        @Query("select * from " + AppDatabase.GRADELOG_TABLE)
        List<GradeLog> getGradeLogs();

//        @Query("SELECT * FROM " + AppDatabase.GRADELOG_TABLE + " WHERE mLogId = :logID")
//        GradeLog getGradeLogWithId(int logID);

        @Query("select * from LogRecord order by time desc")
        List<LogRecord> getAllLogRecords();

        @Insert
        void addLogRecord(LogRecord rec);

}