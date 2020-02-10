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
    private int studentID;
    private int courseID;
    private long date_earned;

    public Grade(){  }

    @Ignore
    public Grade(int gradeID, int score, int assignmentID, int studentID, int courseID, long date_earned) {
        this.gradeID=gradeID;
        this.score=score;
        this.assignmentID=assignmentID;
        this.studentID=studentID;
        this.courseID=courseID;
        this.date_earned=date_earned;
    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Grade Grade = (Grade) o;
//        return  score == Grade.score &&
//                date_earned == Grade.date_earned ;
//    }

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