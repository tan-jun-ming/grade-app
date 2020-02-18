package com.group.a.gradeapp.DB;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;



@Entity(tableName = AppDatabase.GRADE_CATEGORY_TABLE)

public class GradeCategory {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int categoryID;

    private String GradeCatTitle;
    private float Weight;
    private int CourseID; //GradeID ?
    private int AssignedDate;

    public GradeCategory() {    }

    @Ignore
    public GradeCategory(String GradeCatTitle, float Weight, int CourseID, int AssignedDate) {
        this.categoryID=categoryID;
        this.GradeCatTitle=GradeCatTitle;
        this.Weight=Weight;
        this.CourseID = CourseID;
        this.AssignedDate=AssignedDate;

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
        return GradeCatTitle + "\n" +
                categoryID + "\n" +
                Weight + "\n" +
                CourseID + "\n" +
                AssignedDate + "\n" + "\n";
    }

    public String getGradeCatTitle() {
        return GradeCatTitle;
    }

    public void setGradeCatTitle(String gradeCatTitle) {
        GradeCatTitle = gradeCatTitle;
    }



    public float getWeight() {
        return Weight;
    }

    public void setWeight(float weight) {
        Weight = weight;
    }

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int courseID) {
        CourseID = courseID;
    }

    public int getAssignedDate() {
        return AssignedDate;
    }

    public void setAssignedDate(int assignedDate) {
        AssignedDate = assignedDate;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }
}

