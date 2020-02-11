package com.group.a.gradeapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.group.a.gradeapp.DB.AppDatabase;
import com.group.a.gradeapp.DB.LogRecord;
import com.group.a.gradeapp.DB.User;
import com.group.a.gradeapp.DB.UserDAO;

import java.util.Date;


public class CreateAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("CreateAccountActivity", "onCreate called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createaccount);

        Button create_button = findViewById(R.id.create_account_button);
        create_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText username = findViewById(R.id.username);
                EditText password = findViewById(R.id.password);
                EditText firstname = findViewById(R.id.firstname);
                EditText lastname = findViewById(R.id.lastname);

                String name = username.getText().toString();
                String pw = password.getText().toString();
                String first_name = firstname.getText().toString();
                String last_name = lastname.getText().toString();

                if (name.equals("")||pw.equals("")||first_name.equals("")||last_name.equals("")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(CreateAccountActivity.this);
                    builder.setMessage("Please fill all fields");
                    builder.setPositiveButton("OK", null);

                    builder.show();
                    return;
                }

                User user = AppDatabase.getAppDatabase(CreateAccountActivity.this).
                        userDAO().getUserByName(name);

                if (user == null) {

                    // add the new user account into the database
                    User newUser = new User(name, pw, first_name, last_name);

                    UserDAO user_dao = AppDatabase.getAppDatabase(CreateAccountActivity.this).userDAO();
                    user_dao.addUser(newUser);


                    //  Show in the log record that a new account was created
                    Date now = new Date();
                    LogRecord rec = new LogRecord(now, LogRecord.TYPE_NEW_ACCOUNT, name, "");
                    user_dao.addLogRecord(rec);

                    // inform user that new account has been created
                    utils.display_toast(getApplicationContext(), "Account created successfully", true);
                    finish();

                } else {
                    // username already exists.
                    AlertDialog.Builder builder = new AlertDialog.Builder(CreateAccountActivity.this);
                    builder.setMessage("Username not available");
                    builder.setPositiveButton("OK", null);

                    builder.show();
                }

            }
        });
    }

}