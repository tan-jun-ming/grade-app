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
@Entity(tableName = AppDatabase.ENROLLMENT_TABLE, primaryKeys = {"UserID", "CourseID"})
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
     * @param EnrollmentID   the enrollment id
     * @param UserID         the user id
     * @param CourseID       the course id
     * @param EnrollmentDate the enrollment date
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
