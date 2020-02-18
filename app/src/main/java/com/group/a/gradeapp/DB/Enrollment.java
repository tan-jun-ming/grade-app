/**
 * class for creating the Enrollment object
 * @Primary Key: EnrollmentID
 * @takes in the UserID foreign key from User table
 * @takes in the CourseID foreign key from Course table
 * used to see which students are enrolled in each course and the date of their enrollment
 */
package com.group.a.gradeapp.DB;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


/**
 * The type Enrollment.
 */
@Entity(tableName = AppDatabase.ENROLLMENT_TABLE)


public class Enrollment {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int EnrollmentID;
    private int UserID; //StudentID?
    private int CourseID;
    private long EnrollmentDate;


    /**
     * Instantiates a new Enrollment.
     */
    public Enrollment(){    }

    /**
     * Instantiates a new Enrollment.
     *
     * @param EnrollmentID   the enrollment id
     * @param UserID         the user id
     * @param CourseID       the course id
     * @param EnrollmentDate the enrollment date
     */
    @Ignore
    public Enrollment(int EnrollmentID, int UserID, int CourseID, long EnrollmentDate) {
        this.EnrollmentID=EnrollmentID;
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

    /**
     * Gets enrollment id.
     *
     * @return the enrollment id
     */
    public int getEnrollmentID() {
        return EnrollmentID;
    }

    /**
     * Sets enrollment id.
     *
     * @param enrollmentID the enrollment id
     */
    public void setEnrollmentID(int enrollmentID) {
        EnrollmentID = enrollmentID;
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public int getUserID() {
        return UserID;
    }

    /**
     * Sets user id.
     *
     * @param userID the user id
     */
    public void setUserID(int userID) {
        UserID = userID;
    }

    /**
     * Gets course id.
     *
     * @return the course id
     */
    public int getCourseID() {
        return CourseID;
    }

    /**
     * Sets course id.
     *
     * @param courseID the course id
     */
    public void setCourseID(int courseID) {
        CourseID = courseID;
    }

    /**
     * Gets enrollment date.
     *
     * @return the enrollment date
     */
    public long getEnrollmentDate() {
        return EnrollmentDate;
    }

    /**
     * Sets enrollment date.
     *
     * @param enrollmentDate the enrollment date
     */
    public void setEnrollmentDate(long enrollmentDate) {
        EnrollmentDate = enrollmentDate;
    }
}
