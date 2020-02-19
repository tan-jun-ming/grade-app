package com.group.a.gradeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.group.a.gradeapp.DB.AppDatabase;
import com.group.a.gradeapp.DB.Course;
import com.group.a.gradeapp.DB.CourseDAO;
import com.group.a.gradeapp.DB.Enrollment;
import com.group.a.gradeapp.DB.EnrollmentDAO;
import com.group.a.gradeapp.DB.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class EnrollCourseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll_course);


        final AtomicInteger user_id = new AtomicInteger(-1);
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras != null) {
                user_id.set(extras.getInt("user_id"));
            }
        } else {
            user_id.set((int) savedInstanceState.getSerializable("user_id"));
        }



        final Spinner course_spinner = (Spinner) findViewById(R.id.course_spinner);



        ArrayAdapter<Course> adapter = new ArrayAdapter<Course>(this,
                android.R.layout.simple_spinner_item, get_course_array());

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        course_spinner.setAdapter(adapter);

        Button enroll_course_button = findViewById(R.id.enroll_course_button);
        enroll_course_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Course item = (Course) course_spinner.getSelectedItem();





                Integer course_id = Integer.parseInt(course_spinner.getSelectedItem().toString());

                // add the new enrollment into the database
                Enrollment newEnrollment = new Enrollment(user_id.get(), course_id);
                EnrollmentDAO enrollmentDAO = AppDatabase.getAppDatabase(EnrollCourseActivity.this).enrollmentDAO();
                enrollmentDAO.addEnrollment(newEnrollment);






                utils.display_toast(getApplicationContext(), item.toString() + " selected");

            }
        });

    }

    List<Course> get_course_array(){
        return AppDatabase.getAppDatabase(EnrollCourseActivity.this).
                courseDAO().getCoursesByUser(0);
    }


}