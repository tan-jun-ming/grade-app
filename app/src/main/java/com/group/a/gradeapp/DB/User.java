
package com.group.a.gradeapp.DB;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * @author      Shaun Kallis <skallis@csumb.edu>
 * @version     1.6
 * @since       1.2
 */

/**
 *
 * class for creating the User object
 * @PrimaryKey: UserID
 * Gives us username, password, first and last names
 */
@Entity(tableName = AppDatabase.USER_TABLE)
public class User {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int UserID;

    @NonNull
    private String username;
    @NonNull
    private String password;
    @NonNull
    private String first_name;
    @NonNull
    private String last_name;
    @NonNull
    private long time;

    public User() {}



    @Ignore
    public User( String username, String password, String first_name, String last_name){
        this.username=username;
        this.password=password;
        this.first_name=first_name;
        this.last_name=last_name;
        //this.time=datetime.getTime();  java.util.Date datetime, enter this into parameter
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        this.UserID = userID;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

   public String getLast_name() {
        return last_name;
    }

    public void setLast_name( String last_name) {
        this.last_name = last_name;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}


