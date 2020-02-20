package com.group.a.gradeapp.DB;

import android.content.Context;

import androidx.room.Entity;
import androidx.room.Database;
import androidx.room.TypeConverters;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.group.a.gradeapp.DB.TypeConverter.DateTypeConverter;


@Database(entities = {Assignment.class, Course.class, Enrollment.class, Grade.class, GradeCategory.class, LogRecord.class, User.class }, version =2, exportSchema = false)
@TypeConverters(DateTypeConverter.class)

@Entity
public abstract class AppDatabase extends RoomDatabase {

    // singleton
    private static AppDatabase instance;
    public abstract UserDAO userDAO();
    public abstract CourseDAO courseDAO();
    public abstract GradeDAO gradeDAO();

    /**
     * Grade category dao grade category dao.
     *
     * @return the grade category dao
     */
    public abstract GradeCategoryDAO gradeCategoryDAO();
    public abstract AssignmentDAO assignmentDAO();
    public abstract EnrollmentDAO enrollmentDAO();


    public static final String dbName="GradeDB";


    public static final String USER_TABLE ="userTable";

    public static final String COURSE_TABLE ="courseTable";

    public static final String GRADE_TABLE ="gradeTable";

    public static final String ASSIGNMENT_TABLE="assignmentTable";

    public static final String GRADE_CATEGORY_TABLE="gradeCategoryTable";

    public static final String ENROLLMENT_TABLE="enrollmentTable";


    /**
     * Get app database app database.
     *
     * @param context the context
     * @return the app database
     */
    public static AppDatabase getAppDatabase(final Context context){
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class,
                    "Grade Database") // database name
                    .allowMainThreadQueries()  // temporary for now
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return instance;
    }


}

