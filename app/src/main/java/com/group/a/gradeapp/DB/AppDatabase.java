package com.group.a.gradeapp.DB;


import android.content.Context;
import android.util.Log;

import androidx.room.Entity;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.Database;
import androidx.room.TypeConverters;
import com.group.a.gradeapp.DB.TypeConverter.DateTypeConverter;

import java.util.List;


@Database(entities = {LogRecord.class, User.class }, version =1)
@TypeConverters(DateTypeConverter.class)

@Entity

public abstract class AppDatabase extends RoomDatabase {
    public static final String dbName="db-gradelog";
    public static final String GRADELOG_TABLE="gradelog";
    public abstract GradeLogDAO getGradeLogDAO();


    // singleton
    private static AppDatabase instance;

    public abstract GradeLogDAO dao();

    public static AppDatabase getAppDatabase(final Context context){
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class,
                    "GradeDB") // database name
                    .allowMainThreadQueries()  // temporary for now
                    //.fallbackToDestructiveMigration()
                    .build();
        }

        return instance;
    }

    public void loadData(Context context){

        // if user table is empty, then load data for users

        List<User> user_list = AppDatabase.getAppDatabase(context).dao().getAllUsers();

        if (user_list.size() == 0) {
            Log.d("GradeRoom", "loading data ");
            loadUsers(context);

        }
    }

    private void loadUsers(Context context) {
        GradeLogDAO dao = getAppDatabase(context).dao();

        User alice = new User("Alice5!", "Alice5!","Alice", "Wonder");

        dao.addUser(alice);

        Log.d("GradeRoom", "1 user added to database");
    }




}

