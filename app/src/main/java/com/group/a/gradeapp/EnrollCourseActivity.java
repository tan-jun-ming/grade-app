package com.group.a.gradeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.group.a.gradeapp.DB.Course;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Enroll course activity.
 */
public class EnrollCourseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll_course);

        Spinner course_spinner = (Spinner) findViewById(R.id.course_spinner);

        ArrayAdapter<Course> adapter = new ArrayAdapter<Course>(this,
                android.R.layout.simple_spinner_item, get_course_array());

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        course_spinner.setAdapter(adapter);

    }

    /**
     * Get course array list.
     *
     * @return the list
     */
    List<Course> get_course_array(){
        List<Course> ret = new ArrayList<>();
        ret.add(new Course("Dr. C", "Software Engineering", "Professional Code Smelling", 0, 0, 0));
        ret.add(new Course("Dr. Byun", "Algorithms", "This reminds me of a puzzle Luke.", 0, 0, 1));

        return ret;
    }


}
