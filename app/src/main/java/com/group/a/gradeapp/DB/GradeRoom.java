package com.group.a.gradeapp.DB;

import android.content.Context;
import android.util.Log;

import java.util.List;
import java.util.logging.LogRecord;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;




@Database(entities={AppDatabase.class, User.class }, version=1)
public abstract class GradeRoom extends RoomDatabase {
    // singleton
    private static GradeRoom instance;

    public abstract GradeLogDAO dao();

    public static GradeRoom getGradeRoom(final Context context){
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    GradeRoom.class,
                    "GradeDB") // database name
                    .allowMainThreadQueries()  // temporary for now
                    //.fallbackToDestructiveMigration()
                    .build();
        }

        return instance;
    }

    public void loadData(Context context){

        // if user table is empty, then load data for users

        List<User> user_list = GradeRoom.getGradeRoom(context).dao().getAllUsers();

        if (user_list.size() == 0) {
            Log.d("GradeRoom", "loading data ");
            loadUsers(context);

        }
    }

    private void loadUsers(Context context) {
        GradeLogDAO dao = getGradeRoom(context).dao();

        User alice = new User("Alice5!", "Alice5!","Alice", "Wonder");

        dao.addUser(alice);

        Log.d("GradeRoom", "1 user added to database");
    }


}
