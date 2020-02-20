package com.group.a.gradeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.group.a.gradeapp.DB.AppDatabase;
import com.group.a.gradeapp.DB.Course;
import com.group.a.gradeapp.DB.CourseDAO;
import com.group.a.gradeapp.DB.Enrollment;
import com.group.a.gradeapp.DB.EnrollmentDAO;
import com.group.a.gradeapp.DB.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The type Enroll course activity.
 */
public class EnrollCourseActivity extends AppCompatActivity {

    AtomicInteger user_id;
    List<Boolean> enrolled;
    HashSet<Integer> enrollment_set = new HashSet<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll_course);

        user_id = new AtomicInteger(-1);
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras != null) {
                user_id.set(extras.getInt("user_id"));
            }
        } else {
            user_id.set((int) savedInstanceState.getSerializable("user_id"));
        }

        List<Course> courses = get_course_array();
        List<Enrollment> enrollments = get_enrollment_array();

        for (Enrollment e: enrollments){
            enrollment_set.add(e.getCourseID());
        }

        enrolled = new ArrayList<>();
        for (Course c: courses){
            enrolled.add(enrollment_set.contains(c.getCourseID()));
        }


        if (courses.size() == 0){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Error")
                    .setMessage("Please add a course before viewing this page.")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            finish();
                        }
                    });

            builder.create();
            builder.show();
            return;
        }

        final Spinner course_spinner = findViewById(R.id.course_spinner);

        ArrayAdapter<Course> adapter = new ArrayAdapter<Course>(this,
                android.R.layout.simple_spinner_item, courses){
            @Override
            public boolean isEnabled(int position){
                return !enrolled.get(position);
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tx = (TextView)view;

                tx.setTextColor(!enrolled.get(position) ? Color.BLACK : Color.GRAY);

                return view;
            }

        };

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        course_spinner.setAdapter(adapter);

        Button enroll_course_button = findViewById(R.id.enroll_course_button);
        enroll_course_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Course item = (Course) course_spinner.getSelectedItem();

                int course_id = ((Course) course_spinner.getSelectedItem()).getCourseID();

                // add the new enrollment into the database
                if (!enrollment_set.contains(course_id)){
                    Enrollment newEnrollment = new Enrollment(user_id.get(), course_id);
                    EnrollmentDAO enrollmentDAO = AppDatabase.getAppDatabase(EnrollCourseActivity.this).enrollmentDAO();
                    enrollmentDAO.addEnrollment(newEnrollment);
                    utils.display_toast(getApplicationContext(), "Successfully enrolled in " + item.toString());
                    finish();
                } else {
                    utils.display_toast(getApplicationContext(), "You are already enrolled in " + item.toString());
                }



            }
        });

    }

    /**
     * Get course array list.
     *
     * @return the list
     */
    List<Course> get_course_array(){
        return AppDatabase.getAppDatabase(EnrollCourseActivity.this).
                courseDAO().getCoursesAvailable();
    }

    List<Enrollment> get_enrollment_array(){
        return AppDatabase.getAppDatabase(EnrollCourseActivity.this).
                enrollmentDAO().getEnrollmentsByUserId(user_id.get());
    }


}