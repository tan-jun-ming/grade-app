package com.group.a.gradeapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

public class ViewGradeListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_grade_list);

        RecyclerView recycler_view = findViewById(R.id.gradeview_list);

        RecyclerView.LayoutManager layout_manager = new LinearLayoutManager(this);
        recycler_view.setLayoutManager(layout_manager);

        ViewGradeListItem[] grades = get_all_grades();

        GradeViewAdapter grade_adapter = new GradeViewAdapter(grades);
        recycler_view.setAdapter(grade_adapter);
    }

    private ViewGradeListItem[] get_all_grades(){
        // Placeholder grades
        // Call a DB-interface method in the future

        ViewGradeListItem[] grades = {
                new ViewGradeListItem(true, "Exams", 1, 0),
                new ViewGradeListItem(false, "Test 1", 1, 1, 50.0f),
                new ViewGradeListItem(false, "Test 2", 1, 2, 75.0f),
                new ViewGradeListItem(false, "Test 3", 1, 3, null),
                new ViewGradeListItem(true, "Labs", 1, 0, 90f),
                new ViewGradeListItem(false, "Lab 1", 1, 1, 10.0f),
                new ViewGradeListItem(false, "Lab 2", 1, 2, 0.0f),
                new ViewGradeListItem(false, "Lab 3", 1, 3, 20.0f),
                new ViewGradeListItem(true, "Quizzes", 1, 0, 0f),
                new ViewGradeListItem(false, "Quiz 1", 1, 1, 0.0f),
                new ViewGradeListItem(false, "Quiz 2", 1, 2, 0.0f),
                new ViewGradeListItem(false, "Quiz 3", 1, 3, null),
        };

        return grades;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;
    }
}
