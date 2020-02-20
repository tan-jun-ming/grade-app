package com.group.a.gradeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.group.a.gradeapp.DB.AppDatabase;
import com.group.a.gradeapp.DB.User;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Menu activity will call upon buttons that will be displayed in the menu activity layout for user to select.
 */

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        final AtomicInteger user_id = new AtomicInteger(-1);
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras != null) {
                user_id.set(extras.getInt("user_id"));
            }
        } else {
            user_id.set((int) savedInstanceState.getSerializable("user_id"));
        }

        User user = AppDatabase.getAppDatabase(MenuActivity.this).
                userDAO().getUserByID(user_id.get());

        TextView logged_in_name = findViewById(R.id.logged_in_name);
        logged_in_name.setText(user.getFirst_name() + " " + user.getLast_name());

        Button add_course_button = findViewById(R.id.add_course);
        add_course_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // call the add course activity
                Log.d("MenuActivity", "onClick for add course called");
               Intent intent = new Intent(MenuActivity.this, AddCourseActivity.class);
               startActivity(intent);

            }
        });

        Button enroll_course_button = findViewById(R.id.enroll_course_button);
        enroll_course_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // call the enroll course activity
                Log.d("MenuActivity", "onClick add grade category activity called");
                Intent intent = new Intent(MenuActivity.this, EnrollCourseActivity.class);
                intent.putExtra("user_id", user_id.get());
                startActivity(intent);

            }
        });

        Button add_grade_category_button = findViewById(R.id.add_grade_category);
        add_grade_category_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // call the add grade category activity
                Log.d("MenuActivity", "onClick add grade category activity called");
                Intent intent = new Intent(MenuActivity.this, AddGradeCategoryActivity.class);
                startActivity(intent);

            }
        });

        Button add_assignment_button = findViewById(R.id.add_assignment);
        add_assignment_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // call the add assignment activity
                Log.d("MenuActivity", "onClick for add assignment activity called");
                Intent intent = new Intent(MenuActivity.this, AddAssignmentActivity.class);
                startActivity(intent);

            }
        });

        Button view_grade_list_button = findViewById(R.id.view_grade_list);
        view_grade_list_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // call the view grade list activity
                Log.d("MenuActivity", "onClick for view grade list activity called");
                Intent intent = new Intent(MenuActivity.this, ViewGradeListActivity.class);
                intent.putExtra("user_id", user_id.get());
                startActivity(intent);

            }
        });

        Button view_grade_summary_button = findViewById(R.id.view_grade_summary);
        view_grade_summary_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // call the view grade summary activity
                Log.d("MenuActivity", "onClick for view grade summary activity called");
                Intent intent = new Intent(MenuActivity.this, ViewGradeSummaryActivity.class);
                intent.putExtra("user_id", user_id.get());
                startActivity(intent);

            }
        });

        Button return_home_page_button = findViewById(R.id.return_home_page);
        return_home_page_button.setOnClickListener(new View.OnClickListener(){
            // call to exit the application
            @Override
            public void onClick(View v) {
                // call the home page activity
                Log.d("Return to home page", "onClick for home page called");
                finish();

            }
        });


    }
}
