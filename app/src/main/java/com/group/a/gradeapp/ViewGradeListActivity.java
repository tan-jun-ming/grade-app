package com.group.a.gradeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.group.a.gradeapp.ViewGradeList.RecyclerItemClickListener;
import com.group.a.gradeapp.ViewGradeList.ViewGradeListAdapter;
import com.group.a.gradeapp.ViewGradeList.ViewGradeListItem;

import java.util.ArrayList;

public class ViewGradeListActivity extends AppCompatActivity {

    private ViewGradeListAdapter grade_adapter;
    private ArrayList<ViewGradeListItem> grades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_grade_list);

        grades = new ArrayList<ViewGradeListItem>();

        RecyclerView recycler_view = findViewById(R.id.gradeview_list);

        RecyclerView.LayoutManager layout_manager = new LinearLayoutManager(this);
        recycler_view.setLayoutManager(layout_manager);

        RecyclerItemClickListener listener = new RecyclerItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                utils.display_toast(ViewGradeListActivity.this, "Item " + position + " Clicked");
                open_assignment(position);
            }
        };

        grade_adapter = new ViewGradeListAdapter(listener);
        recycler_view.setAdapter(grade_adapter);

        update_grades();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        update_grades();
    }

    private void update_grades(){
        grades = get_grades();
        grade_adapter.update(grades);
    }

    private void open_assignment(int position){
        ViewGradeListItem item = grades.get(position);

        if (item.is_category){
            Intent intent = new Intent(ViewGradeListActivity.this, AddAssignmentActivity.class);
            intent.putExtra("category_id", item.category_id);
            intent.putExtra("category_name", item.name);
            startActivity(intent);
        } else {
            // open edit assignment here
        }

    }

    private ArrayList<ViewGradeListItem> get_grades(){
        // Placeholder grades
        // Call a DB-interface method in the future

        ArrayList<ViewGradeListItem> grades = new ArrayList<ViewGradeListItem>();

        grades.add(new ViewGradeListItem(true, "Exams", 1, 0));
        grades.add(new ViewGradeListItem(false, "Test 1", 1, 1, 50.0f));
        grades.add(new ViewGradeListItem(false, "Test 2", 1, 2, 75.0f));
        grades.add(new ViewGradeListItem(false, "Test 3", 1, 3, null));
        grades.add(new ViewGradeListItem(true, "Labs", 1, 0, 90f));
        grades.add(new ViewGradeListItem(false, "Lab 1", 1, 1, 10.0f));
        grades.add(new ViewGradeListItem(false, "Lab 2", 1, 2, 0.0f));
        grades.add(new ViewGradeListItem(false, "Lab 3", 1, 3, 20.0f));
        grades.add(new ViewGradeListItem(true, "Quizzes", 1, 0, 0f));
        grades.add(new ViewGradeListItem(false, "Quiz 1", 1, 1, 0.0f));
        grades.add(new ViewGradeListItem(false, "Quiz 2", 1, 2, 0.0f));
        grades.add(new ViewGradeListItem(false, "Quiz 3", 1, 3, null));

        return grades;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;
    }
}
