package com.group.a.gradeapp.DB;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;



@Entity(tableName = AppDatabase.GRADE_TABLE)

public class Grade {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int gradeID;

    private int score;
    private int assignmentID;
    private int UserID;
    private int courseID;


    public Grade(){  }

    @Ignore
    public Grade(int score, int assignmentID, int UserID, int courseID) {
        this.score=score;
        this.assignmentID=assignmentID;
        this.UserID =UserID;
        this.courseID=courseID;
    }



    @Override
    public String toString() {
        return  gradeID + "\n" +
                score  + "\n" +
                assignmentID + "\n" +
                UserID + "\n" +
                courseID + "\n" + "\n";
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

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        this.UserID = userID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }


}