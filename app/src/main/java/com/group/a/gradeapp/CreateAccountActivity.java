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
import com.group.a.gradeapp.DB.User;


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
                        UserDAO().getUserByName(username.getText().toString());

                if (user == null) {
                    // username does not exist, so add the new account
                    String name = username.getText().toString();
                    String pw = password.getText().toString();
                    String first_name = firstname.getText().toString();
                    String last_name = lastname.getText().toString();

                    // inform user that new account has been created
                    utils.display_toast(getApplicationContext(), "Account created successfully", true);
                    finish();

                } else {
                    // username already exists.
                    utils.display_toast(getApplicationContext(), "Username not available", true);

                }

            }
        });
    }

}