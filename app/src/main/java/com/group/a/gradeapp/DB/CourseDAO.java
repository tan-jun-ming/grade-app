package com.group.a.gradeapp.DB;

import androidx.room.Insert;
import androidx.room.Query;

import com.group.a.gradeapp.DB.AppDatabase;
import com.group.a.gradeapp.DB.Course;

import java.util.List;

public interface CourseDAO {

    @Query("select * from courseTable")
    List<Course> getAllCourses();

    @Query("select * from courseTable where courseID = :courseID")
    Course getCourseByID(int courseID);

    @Insert
    void addCourse(Course course);


//    @Query("select * from LogRecord order by time desc")
//    List<LogRecord> getAllLogRecords();

//    @Insert
//    void addLogRecord(LogRecord rec);



}
