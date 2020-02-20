/**
 * class for creating the Grade object
 * @PrimaryKey: GradeID
 * @takes in the CourseID foreign key from the Course table
 * @takes in the AssignmentID foreign key from the Assignment table
 * @takes in the UserID foreign key from the User table
 * Gives us the grade the student earned for the assignment and the date they earned that grade
 */
package com.group.a.gradeapp.DB;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;



@Entity(tableName = AppDatabase.GRADE_TABLE, primaryKeys = {"UserID", "assignmentID"})
public class Grade {
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
        return  score  + "\n" +
                assignmentID + "\n" +
                UserID + "\n" +
                courseID + "\n" + "\n";
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