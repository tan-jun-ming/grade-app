/**
 * class for creating the Enrollment object
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
    private int UserID;
    private int CourseID;


/**
 * Instantiates a new Enrollment.
 */
    public Enrollment(){    }

    /**
     * Instantiates a new Enrollment.
     *
     * @param UserID         the user id
     * @param CourseID       the course id
     */
    @Ignore
    public Enrollment(int UserID, int CourseID) {
        this.UserID=UserID;
        this.CourseID=CourseID;

    }




    @Override
    public String toString() {
        return  UserID + "\n" +
                CourseID + "\n" + "\n";
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

}
