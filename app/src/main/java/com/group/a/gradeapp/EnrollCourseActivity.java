package com.group.a.gradeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.group.a.gradeapp.DB.Course;

import java.util.ArrayList;

public class EnrollCourseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll_course);

        Spinner course_spinner = (Spinner) findViewById(R.id.course_spinner);

//        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<Course>(this,
//                get_course_array(), android.R.layout.simple_spinner_item);
//
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//        course_spinner.setAdapter(adapter);

    }

    ArrayList<Course> get_course_array(){
        ArrayList<Course> ret = new ArrayList<Course>();
        ret.add(new Course("Dr. C", "Software Engineering", "Professional Code Smelling", 0, 0, 0));
        ret.add(new Course("Dr. Byun", "Algorithms", "This reminds me of a puzzle Luke.", 0, 0, 1));

        return ret;
    }
}
