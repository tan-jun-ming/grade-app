package com.group.a.gradeapp.DB;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;



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

    public Course(){    }

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

    public String get_info() {
        return Title + "\n" +
                Instructor + "\n" +
                Description + "\n" +
                Start_date + "\n" +
                End_date + "\n" +
                courseID + "\n" + "\n";
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getInstructor() {
        return Instructor;
    }

    public void setInstructor(String instructor) {
        Instructor = instructor;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public long getStart_date() {
        return Start_date;
    }

    public void setStart_date(long start_date) {
        Start_date = start_date;
    }

    public long getEnd_date() {
        return End_date;
    }

    public void setEnd_date(long end_date) {
        End_date = end_date;
    }
}
