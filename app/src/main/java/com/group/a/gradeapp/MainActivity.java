package com.group.a.gradeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button create_account_button = findViewById(R.id.create_account);
        create_account_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // call the create account activity
                Log.d("MainActivity", "onClick for create account called");
                Intent intent = new Intent(MainActivity.this, CreateAccountActivity.class);
                startActivity(intent);

            }
        });


        Button login_button = findViewById(R.id.login);
        login_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // call the login Activity
                Log.d("Login", "onClick for login activity called");
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });



        Button logout_button = findViewById(R.id.logout);
        logout_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // call the logout Activity
                Log.d("Logout", "onClick for logout activity called");
                Intent intent = new Intent(MainActivity.this, LogoutActivity.class);
                startActivity(intent);

            }
        });


        Button exit_button = findViewById(R.id.exit);
        exit_button.setOnClickListener(new View.OnClickListener(){
            // call to exit the application
            @Override
            public void onClick(View v) {
                Log.d("Exit", "onClick for exit called");
                finish();

            }
        });





    }
}
