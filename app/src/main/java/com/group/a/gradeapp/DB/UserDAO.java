package com.group.a.gradeapp.DB;

import java.util.List;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;



@Dao
public interface UserDAO {

    @Query("select * from userTable")
    List<User> getAllUsers();

    //@Query("select* from User where id in (:)")

    @Query("select * from " + AppDatabase.USER_TABLE)
    List<User> getuser();

    @Query("select * from userTable where username = :username")
    User getUserByName(String username);

    @Insert
    void addUser(User user);

    @Query("select * from userTable order by time desc")
    List<User> getAllLogRecords();

    @Insert
    void addLogRecord(LogRecord rec);








}