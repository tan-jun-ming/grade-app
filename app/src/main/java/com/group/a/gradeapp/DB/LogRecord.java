package com.group.a.gradeapp.DB;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Ignore;


@Entity
public class LogRecord {

    public static final String TYPE_NEW_ACCOUNT ="Account Created";
  //  public static final String TYPE_GRADE_LOG ="Grade Log";



    @NonNull
    @PrimaryKey(autoGenerate=true)
    private int UserID;
    @NonNull
    private long time;
    @NonNull
    private String transaction_type;   // new account
    @NonNull
    private String username;
    @NonNull
    private String detailed_message;




    public LogRecord() {
    }

    @Ignore
    public LogRecord(java.util.Date datetime, String type, String username, String detailed_message){
        this.time = datetime.getTime();
        this.transaction_type = type;
        this.username = username;
        this.detailed_message = detailed_message;
    }




    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        this.UserID = userID;
    }

    @NonNull
    public java.util.Date getDatetime() {
        return new java.util.Date(time);
    }

    public long getTime() { return time;}
    public void setTime(long time) { this.time = time; }

    @NonNull
    public String getTransaction_type() {
        return transaction_type;
    }

    public void setTransaction_type(@NonNull String transaction_type) {
        this.transaction_type = transaction_type;
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    @NonNull
    public String getDetailed_message() {
        return detailed_message;
    }

    public void setDetailed_message(@NonNull String detailed_message) {
        this.detailed_message = detailed_message;
    }

    @Override
    public String toString() {
        String s = transaction_type +"\n"+ getDatetime()+"  "+"\nUsername: "+username;
        if (transaction_type.equals(TYPE_NEW_ACCOUNT))  {
            return s;
        } else {
            return s + "\n" + detailed_message;
        }
    }

}
