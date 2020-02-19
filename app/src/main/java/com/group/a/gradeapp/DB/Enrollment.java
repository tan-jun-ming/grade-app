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

    private int UserID; //StudentID?
    private int CourseID;
    private long EnrollmentDate;



    public Enrollment(){    }

    @Ignore
    public Enrollment(int UserID, int CourseID, long EnrollmentDate) {
        this.UserID=UserID;
        this.CourseID=CourseID;
        this.EnrollmentDate=EnrollmentDate;
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
        return EnrollmentID + "\n" +
                UserID + "\n" +
                CourseID + "\n" +
                EnrollmentDate + "\n" + "\n";
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

    public long getEnrollmentDate() {
        return EnrollmentDate;
    }

    public void setEnrollmentDate(long enrollmentDate) {
        EnrollmentDate = enrollmentDate;
    }
}
