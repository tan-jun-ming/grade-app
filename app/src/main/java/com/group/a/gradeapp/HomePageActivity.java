package com.group.a.gradeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.group.a.gradeapp.DB.GradeDAO;
import com.group.a.gradeapp.DB.User;

/**
 * Home page activity.
 */
public class HomePageActivity extends AppCompatActivity {

    /**
     * The constant username.
     */
    public static String username = null;   // username if logged in
    //public static Integer userID = null;

    // check database
//        AppDatabase.getAppDatabase(HomePageActivity.this).loadData(this);

    /**
     * The My grade dao.
     */
    GradeDAO myGradeDAO;
    /**
     * The My user.
     */
    User myUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

//        myGradeDAO = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.dbName)
//                .allowMainThreadQueries()
//                .build()
//                .getGradeLogDAO();

        Button create_account_button = findViewById(R.id.create_account);
        create_account_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // call the create account activity
                Log.d("HomePageActivity", "onClick for create account called");
                Intent intent = new Intent(HomePageActivity.this, CreateAccountActivity.class);
                startActivity(intent);

            }
        });

        Button login_button = findViewById(R.id.login);
        login_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // call the login Activity
                Log.d("Login", "onClick for login activity called");
                Intent intent = new Intent(HomePageActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });

        Button view_logs_button = findViewById(R.id.viewlogs);
        view_logs_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // call the view log activity
                Log.d("HomePageActivity", "onClick for view log called");
                Intent intent = new Intent(HomePageActivity.this, ViewLogActivity.class);
                startActivity(intent);

            }
        });

        Button exit_button = findViewById(R.id.exit);
        exit_button.setOnClickListener(new View.OnClickListener(){
            // call to exit the application
            @Override
            public void onClick(View v) {
                Log.d("Exit", "onClick for exit called");
                finish();  // make it actually close app from anywhere !!

            }
        });





    }
}
