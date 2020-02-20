/**
 * class for creating the Course object
 * @Primary Key: CourseID
 * Gives us the Istructor, CourseTitle, course description, start and end dates
 */
package com.group.a.gradeapp.DB;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


/**
 * The type Course.
 */
@Entity(tableName = AppDatabase.COURSE_TABLE)

public class Course {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int courseID;

    private String Instructor;
    private String Title;
    private String Description;
    private long Start_date;
    private long End_date;

    /**
     * Instantiates a new Course.
     */
    public Course(){    }

    /**
     * Instantiates a new Course.
     *
     * @param Instructor  the instructor
     * @param Title       the title
     * @param Description the description
     * @param Start_date  the start date
     * @param End_date    the end date
     * @param courseID    the course id
     */
    @Ignore
    public Course(String Instructor, String Title, String Description, long Start_date, long End_date) {
        this.Instructor = Instructor;
        this.Title = Title;
        this.Description = Description;
        this.Start_date = Start_date;
        this.End_date = End_date;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course Course = (Course) o;
        return Title == Course.Title &&
                Instructor == Course.Instructor &&
                Start_date == Course.Start_date;
    }

    @Override
    public String toString() {
        return Title;
    }

    /**
     * Gets info.
     *
     * @return the info
     */
    public String get_info() {
        return Title + "\n" +
                Instructor + "\n" +
                Description + "\n" +
                Start_date + "\n" +
                End_date + "\n" +
                courseID + "\n" + "\n";
    }

    /**
     * Gets course id.
     *
     * @return the course id
     */
    public int getCourseID() {
        return courseID;
    }

    /**
     * Sets course id.
     *
     * @param courseID the course id
     */
    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    /**
     * Gets instructor.
     *
     * @return the instructor
     */
    public String getInstructor() {
        return Instructor;
    }

    /**
     * Sets instructor.
     *
     * @param instructor the instructor
     */
    public void setInstructor(String instructor) {
        Instructor = instructor;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return Title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        Title = title;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        Description = description;
    }

    /**
     * Gets start date.
     *
     * @return the start date
     */
    public long getStart_date() {
        return Start_date;
    }

    /**
     * Sets start date.
     *
     * @param start_date the start date
     */
    public void setStart_date(long start_date) {
        Start_date = start_date;
    }

    /**
     * Gets end date.
     *
     * @return the end date
     */
    public long getEnd_date() {
        return End_date;
    }

    /**
     * Sets end date.
     *
     * @param end_date the end date
     */
    public void setEnd_date(long end_date) {
        End_date = end_date;
    }
}
