package com.group.a.gradeapp.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import java.util.List;

@Dao
public interface EnrollmentDAO {
    @Insert
    void AddEnrollment( Enrollment Enrollment);

    @Update
    void update(Enrollment... Enrollments);
    @Delete
    void delete(Enrollment Enrollment);

    @Query("select * from " + AppDatabase.ENROLLMENT_TABLE)
    List<Enrollment> getEnrollments();

//    @Query("select * from assignmentTable where AssTitle = :AssTitle")
//    Enrollment getEnrollmentByID(String AssTitle);

    @Insert
    void addEnrollment(Enrollment Enrollment);






// log record queries
    @Query("select * from LogRecord order by time desc")
    List<LogRecord> getAllLogRecords();

    @Insert
    void addLogRecord(LogRecord rec);

}

