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

public class EnrollCourseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll_course);






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


                int enrollmentId=Enrollment.getEnrollmentID();
                int userId= User.getUserID();
                String course_id = course_spinner.getSelectedItem().toString();
                long enrollmentDate =;


                // add the new Grade Category into the database
                Enrollment newEnrollment = new Enrollment(enrollmentId, userId, course_id, enrollmentDate);
                EnrollmentDAO enrollmentDAO = AppDatabase.getAppDatabase(EnrollCourseActivity.this).enrollmentDAO();
                enrollmentDAO.addEnrollment(newEnrollment);






                utils.display_toast(getApplicationContext(), item.toString() + " selected");

            }
        });

    }

    List<Course> get_course_array(){
        return AppDatabase.getAppDatabase(EnrollCourseActivity.this).
                courseDAO().getAllCourses();
    }


}