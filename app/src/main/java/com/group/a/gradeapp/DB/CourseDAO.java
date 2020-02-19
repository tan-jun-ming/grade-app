package com.group.a.gradeapp.DB;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.group.a.gradeapp.DB.AppDatabase;
import com.group.a.gradeapp.DB.Course;

import java.util.List;

@Dao
public interface CourseDAO {

    @Query("select * from courseTable")
    List<Course> getCoursesAvailable();

    @Query("select * from courseTable natural join enrollmentTable where UserID=:UserID")
    List <Course> getCoursesByUser(Integer UserID);

    @Query("select * from " + AppDatabase.COURSE_TABLE)
    List<Course> getcourse();

    @Query("select * from courseTable where Title = :Title")
    Course getCourseByTitle(String Title);

    @Insert
    void addCourse(Course course);


//    @Query("select * from LogRecord order by time desc")
//    List<LogRecord> getAllLogRecords();

//    @Insert
//    void addLogRecord(LogRecord rec);



}
