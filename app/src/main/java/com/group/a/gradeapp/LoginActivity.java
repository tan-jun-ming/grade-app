package com.group.a.gradeapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("LoginActivity", "onCreate called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button login_button = findViewById(R.id.login_button);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText username = findViewById(R.id.username);
                EditText password = findViewById(R.id.password);

//                if (username.getText().toString().equals("!admiM2") &&
//                        password.getText().toString().equals("!admiM2")) {
//                    // special admin userid
//                    MainActivity.username = username.getText().toString();
//
//                    finish();
//                }

                String name = username.getText().toString();
                String pw = password.getText().toString();




            }
        });

    }


}