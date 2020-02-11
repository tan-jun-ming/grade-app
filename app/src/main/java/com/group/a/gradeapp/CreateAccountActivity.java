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
    private int counterrors = 0;

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


                User user = AppDatabase.getAppDatabase(CreateAccountActivity.this).
                        userDAO().getUserByName(username.getText().toString());

                if (user == null) {
                    // username does not exist, so add the new account
                    String name = username.getText().toString();
                    String pw = password.getText().toString();
                    String first_name = firstname.getText().toString();
                    String last_name = lastname.getText().toString();

                    //prompts the user that username or password is invalid
                    if (!checkvalid(name) || !checkvalid(pw)) {
                        TextView msg = findViewById(R.id.notify);
                        msg.setText(" Invalid username or password.");
                        counterrors++;

                        if (counterrors >= 2) {
                            //informing the user that to many attempts have been tried
                            AlertDialog.Builder builder = new AlertDialog.Builder(CreateAccountActivity.this);
                            builder.setTitle("Too many attempts.");
                            builder.setPositiveButton("Continue to main menu", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            });

                            AlertDialog dialog = builder.create();
                            dialog.show();
                        }
                        return;
                    }



                    // add the new user account into the database
                    User newUser = new User(name, pw, first_name, last_name);

                    UserDAO user_dao = AppDatabase.getAppDatabase(CreateAccountActivity.this).userDAO();
                    user_dao.addUser(newUser);


//                  //  Show in the log record that a new account was created
                    Date now = new Date();
                    LogRecord rec = new LogRecord(now, LogRecord.TYPE_NEW_ACCOUNT, name, "");
                    user_dao.addLogRecord(rec);




                    // inform user that new account has been created
                    AlertDialog.Builder builder = new AlertDialog.Builder(CreateAccountActivity.this);
                    builder.setTitle("Account successfully created.");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });

                    AlertDialog dialog = builder.create();
                    dialog.show();

                } else {
                    // username already exists.
                    TextView msg = findViewById(R.id.notify);
                    msg.setText("Username not available.");
                    counterrors++;

                    if (counterrors >= 2) {
                        //informing the user that to many attempts have been tried
                        AlertDialog.Builder builder = new AlertDialog.Builder(CreateAccountActivity.this);
                        builder.setTitle("Too many attempts.");
                        builder.setPositiveButton("Continue to main menu", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });

                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }

                }

            }
        });
    }

    // method checking validity of inputted username and password

    private boolean checkvalid(String S) {
        boolean digit = false;
        boolean lower = false;
        boolean upper = false;
        boolean special = false;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if ('0' <= c && c <= '9') {
                digit = true;
            } else if ('a' <= c && c <= 'z') {
                lower = true;
            } else if ('A' <= c && c <= 'Z') {
                upper = true;
            } else if (c == '!' || c == '@' || c == '#' || c == '$') {
                special = true;
            }
        }
        return digit && lower && upper && special;
    }


    //    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_create_account);
//
//        final Button button = findViewById(R.id.create_account_button);
//        button.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                create_account();
//            }
//        });
//    }
//
//    public void create_account(){
//        final EditText username = findViewById(R.id.username);
//        final EditText password = findViewById(R.id.password);
//        final EditText firstname = findViewById(R.id.firstname);
//        final EditText lastname = findViewById(R.id.lastname);
//
//        boolean result = create_account(username.getText().toString(), password.getText().toString(), firstname.getText().toString(), lastname.getText().toString());
//        String notify_string = result ? "Account Created Successfully" : "Account Creation Failed";
//
//        utils.display_toast(this, notify_string);
//
//        if (result) {
//            finish();
//        }
//
//    }
//
//    public boolean create_account(String username, String password, String firstname, String lastname){
//        // access database here
//        return true;
//    }


}