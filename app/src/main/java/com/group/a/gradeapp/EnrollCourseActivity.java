package com.group.a.gradeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.group.a.gradeapp.CourseSpinner.CourseListItem;
import com.group.a.gradeapp.DB.Course;

import java.util.ArrayList;
import java.util.List;

public class EnrollCourseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll_course);

        Spinner course_spinner = (Spinner) findViewById(R.id.course_spinner);

        ArrayAdapter<CourseListItem> adapter = new ArrayAdapter<CourseListItem>(this,
                android.R.layout.simple_spinner_item, get_course_array());

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        course_spinner.setAdapter(adapter);

    }

    List<CourseListItem> get_course_array(){
        List<CourseListItem> ret = new ArrayList<>();
        ret.add(new CourseListItem(0, "CST200"));
        ret.add(new CourseListItem(1, "CST300"));

        return ret;
    }


}
