package com.group.a.gradeapp.DB;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


@Entity(tableName = AppDatabase.ENROLLMENT_TABLE)


public class Enrollment {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int EnrollmentID;

    private int UserID;
    private int CourseID;



    public Enrollment(){    }

    @Ignore
    public Enrollment(int UserID, int CourseID) {
        this.UserID=UserID;
        this.CourseID=CourseID;

    }




    @Override
    public String toString() {
        return EnrollmentID + "\n" +
                UserID + "\n" +
                CourseID + "\n" + "\n";
    }

    public int getEnrollmentID() {
        return EnrollmentID;
    }

    public void setEnrollmentID(int enrollmentID) {
        EnrollmentID = enrollmentID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int courseID) {
        CourseID = courseID;
    }

}
