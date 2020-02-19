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
    private int EarnedScore;

   public Assignment() {   }

   @Ignore
    public Assignment(String AssTitle, String Details, Integer Maxscore, Integer EarnedScore, Integer CategoryID) {
    this.CategoryID=CategoryID;
    this.CourseID=CourseID;
    this.AssTitle=AssTitle;
    this.AssignedDate=AssignedDate;
    this.DueDate=DueDate;
    this.Details=Details;
    this.MaxScore=MaxScore;
    this.EarnedScore=EarnedScore;
    }






//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Course Course = (Course) o;
//        return Title == Course.Title &&
//                Instructor == Course.Instructor &&
//                Start_date == Course.Start_date;
//    }

    @Override
    public String toString() {
        return AssignmentID + "\n" +
                CategoryID + "\n" +
                AssTitle + "\n" +
                CourseID + "\n" +
                AssignedDate + "\n" +
                DueDate + "\n" +
               Details + "\n" +
               MaxScore + "\n" +
               EarnedScore + "\n" + "\n";
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

    public int getEarnedScore() {
        return EarnedScore;
    }

    public void setEarnedScore(int earnedScore) {
        EarnedScore = earnedScore;
    }
}

