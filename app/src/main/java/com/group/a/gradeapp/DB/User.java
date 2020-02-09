package com.group.a.gradeapp.DB;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


@Entity(tableName = AppDatabase.USER_TABLE)
public class User {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    @NonNull
    private String username;
    @NonNull
    private String password;
    @NonNull
    private String first_name;
    @NonNull
    private String last_name;

    public User() {}



    @Ignore
    public User(String username, String password, String first_name, String last_name){
        this.username=username;
        this.password=password;
        this.first_name=first_name;
        this.last_name=last_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return id;
    }

    public void setUser_id(int user_id) {
        this.id = id;
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


}


