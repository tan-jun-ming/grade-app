package com.group.a.gradeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.group.a.gradeapp.ViewGradeList.ViewGradeListActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button add_course_button = findViewById(R.id.add_course);
        add_course_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // call the add course activity
                Log.d("HomePageActivity", "onClick for add course called");
               Intent intent = new Intent(MenuActivity.this, AddCourseActivity.class);
               startActivity(intent);

            }
        });

        Button add_grade_category_button = findViewById(R.id.add_grade_category);
        add_grade_category_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // call the add grade category activity
                Log.d("Login", "onClick add grade category activity called");
                Intent intent = new Intent(MenuActivity.this, AddGradeCategoryActivity.class);
                startActivity(intent);

            }
        });

        Button add_assignment_button = findViewById(R.id.add_assignment);
        add_assignment_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // call the add assignment activity
                Log.d("Logout", "onClick for add assignment activity called");
                Intent intent = new Intent(MenuActivity.this, AddAssignmentActivity.class);
                startActivity(intent);

            }
        });

        Button add_grade_button = findViewById(R.id.add_grade);
        add_grade_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // call the add grade activity
                Log.d("HomePageActivity", "onClick for add grade activity called");
                Intent intent = new Intent(MenuActivity.this, AddGradeActivity.class);
                startActivity(intent);

            }
        });

        Button view_assignment_list_button = findViewById(R.id.view_assignment_list);
        view_assignment_list_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // call the view assignment list activity
                Log.d("HomePageActivity", "onClick for view assignment list activity called");
                Intent intent = new Intent(MenuActivity.this, ViewAssignmentListActivity.class);
                startActivity(intent);

            }
        });

        Button view_grade_list_button = findViewById(R.id.view_grade_list);
        view_grade_list_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // call the view grade list activity
                Log.d("Login", "onClick for view grade list activity called");
                Intent intent = new Intent(MenuActivity.this, ViewGradeListActivity.class);
                startActivity(intent);

            }
        });

        Button view_grade_summary_button = findViewById(R.id.view_grade_summary);
        view_grade_summary_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // call the view grade summary activity
                Log.d("Logout", "onClick for view grade summary activity called");
                Intent intent = new Intent(MenuActivity.this, ViewGradeSummaryActivity.class);
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
                Intent intent = new Intent(MenuActivity.this, HomePageActivity.class);
                startActivity(intent);

            }
        });


    }
}
