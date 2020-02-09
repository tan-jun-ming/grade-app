package com.group.a.gradeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class GradesView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades_view);

        RecyclerView recycler_view = findViewById(R.id.gradeview_list);

        RecyclerView.LayoutManager layout_manager = new LinearLayoutManager(this);
        recycler_view.setLayoutManager(layout_manager);

        java.lang.String[] grades = {};

        GradeViewAdapter grade_adapter = new GradeViewAdapter(grades);
        recycler_view.setAdapter(grade_adapter);
    }
}
