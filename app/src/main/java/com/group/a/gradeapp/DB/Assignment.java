package com.group.a.gradeapp.DB;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;



@Entity(tableName = AppDatabase.ASSIGNMENT_TABLE)

public class Assignment {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int AssignmentID;

    private String AssTitle;
    private int CategoryID;
    private int CourseID;
    private long AssignedDate;
    private long DueDate;
    private String Details;
    private int MaxScore;

   public Assignment() {   }

   @Ignore
    public Assignment(String AssTitle, String Details, Integer MaxScore, Integer CategoryID, long AssignedDate, long DueDate) {
    this.CategoryID=CategoryID;
    this.AssTitle=AssTitle;
    this.AssignedDate=AssignedDate;
    this.DueDate=DueDate;
    this.Details=Details;
    this.MaxScore=MaxScore;
    }

    @Override
    public String toString() {
        return
               Details + "\n";
   }

    public String getAssTitle() {
        return AssTitle;
    }

    public void setAssTitle(String assTitle) {
        AssTitle = assTitle;
    }

    public int getAssignmentID() {
        return AssignmentID;
    }

    public void setAssignmentID(int assignmentID) {
        AssignmentID = assignmentID;
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int categoryID) {
        CategoryID = categoryID;
    }

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int courseID) {
        CourseID = courseID;
    }

    public long getAssignedDate() {
        return AssignedDate;
    }

    public void setAssignedDate(long assignedDate) {
        AssignedDate = assignedDate;
    }

    public long getDueDate() {
        return DueDate;
    }

    public void setDueDate(long dueDate) {
        DueDate = dueDate;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }

    public int getMaxScore() {
        return MaxScore;
    }

    public void setMaxScore(int maxScore) {
        MaxScore = maxScore;
    }
}

