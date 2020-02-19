package com.group.a.gradeapp.DB;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


@Dao
public interface GradeDAO {

        @Insert
        void addGrade( Grade grade);

        @Update
        void update(Grade... grades);
        @Delete
        void delete(Grade grade);

        @Query("select * from " + AppDatabase.GRADE_TABLE)
        List<Grade> getAllGrades();

        @Query("SELECT * FROM " + AppDatabase.GRADE_TABLE + " WHERE courseId=:courseId AND UserID=:UserID")
        List<Grade> getGradesByCourseIDAndUserID(int courseId, int UserID);


        @Query("SELECT * FROM " + AppDatabase.GRADE_TABLE + " WHERE assignmentID=:assignmentID AND UserID=:UserID")
        Grade getGradeByAssignmentIDAndUserID(int assignmentID, int UserID);



}