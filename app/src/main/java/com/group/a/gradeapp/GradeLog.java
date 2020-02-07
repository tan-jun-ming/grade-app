package com.group.a.gradeapp;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.group.a.gradeapp.DB.AppDatabase;

import java.util.Date;


@Entity(tableName = AppDatabase.GRADELOG_TABLE)

public class GradeLog {
    @PrimaryKey(autoGenerate = true)
    private int gradeID;
    private int score;
    private int assignmentID;
    private int studentID;
    private int courseID;
    private long date_earned;

    public GradeLog(int gradeID, int score, int assignmentID, int studentID, int courseID, long date_earned) {
        this.gradeID=gradeID;
        this.score=score;
        this.assignmentID=assignmentID;
        this.studentID=studentID;
        this.courseID=courseID;
        this.date_earned=date_earned;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GradeLog GradeLog = (GradeLog) o;
        return  score == GradeLog.score &&
                date_earned == GradeLog.date_earned ;
    }

    @Override
    public String toString() {
        return  gradeID + "\n" +
                score  + "\n" +
                assignmentID + "\n" +
                studentID + "\n" +
                courseID + "\n" +
                date_earned + "\n" + "\n";
    }


    public int getGradeID() {
        return gradeID;
    }

    public void setGradeID(int gradeID) {
        this.gradeID = gradeID;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAssignmentID() {
        return assignmentID;
    }

    public void setAssignmentID(int assignmentID) {
        this.assignmentID = assignmentID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public long getDate_earned() {
        return date_earned;
    }

    public void setDate_earned(long date_earned) {
        this.date_earned = date_earned;
    }
}