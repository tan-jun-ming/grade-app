package com.group.a.gradeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.group.a.gradeapp.DB.Course;
import com.group.a.gradeapp.ViewGradeList.RecyclerItemClickListener;
import com.group.a.gradeapp.ViewGradeList.ViewGradeListAdapter;
import com.group.a.gradeapp.ViewGradeList.ViewGradeListItem;

import java.util.ArrayList;
import java.util.List;

public class ViewGradeListActivity extends AppCompatActivity {

    private ViewGradeListAdapter grade_adapter;
    private ArrayList<ViewGradeListItem> grades;
    private int selected_course_id;
    private List<Course> course_array;

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
                open_assignment(position);
            }
        };

        grade_adapter = new ViewGradeListAdapter(listener);
        recycler_view.setAdapter(grade_adapter);

        final Spinner course_spinner = (Spinner) findViewById(R.id.course_spinner);

        course_array = get_course_array();

        ArrayAdapter<Course> adapter = new ArrayAdapter<Course>(this,
                android.R.layout.simple_spinner_item, course_array);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        course_spinner.setAdapter(adapter);

        course_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                selected_course_id = course_array.get(position).getCourseID();
                update_grades();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button add_grade_category_button = findViewById(R.id.add_grade_category_button);

        add_grade_category_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewGradeListActivity.this, AddGradeCategoryActivity.class);
                intent.putExtra("course_id", selected_course_id);
                startActivity(intent);

            }
        });

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        update_grades();
    }

    /**
     * Update grades
     */
    private void update_grades(){
        grades = get_grades(selected_course_id);
        grade_adapter.update(grades);
    }

    List<Course> get_course_array(){
        List<Course> ret = new ArrayList<>();
        ret.add(new Course("Dr. C", "Software Engineering", "Professional Code Smelling"));
        ret.add(new Course("Dr. Byun", "Algorithms", "This reminds me of a puzzle Luke."));

        return ret;
    }

    /**
     * Opens the assigment or category at the position as a Grade Summary or Add Assignment Activity
     *
     * @param position Position of the item in the recycler
     */
    private void open_assignment(int position){
        ViewGradeListItem item = grades.get(position);

        if (item.is_category){
            Intent intent = new Intent(ViewGradeListActivity.this, AddAssignmentActivity.class);
            intent.putExtra("category_id", item.category_id);
            startActivity(intent);
        } else {
            // open edit assignment here
        }

    }

    /**
     * Gets the category and assignment grades from the database
     *
     * @return ArrayList of ViewGradeListItem for displaying in the recycler
     */
    private ArrayList<ViewGradeListItem> get_grades(int selected_course_id){
        // Placeholder grades
        // Call a DB-interface method in the future

        ArrayList<ViewGradeListItem> grades = new ArrayList<ViewGradeListItem>();

        if (selected_course_id == 0){
            grades.add(new ViewGradeListItem(true, "Exams", 1, 0));
            grades.add(new ViewGradeListItem(false, "Test 1", 1, 1, 50.0f));
            grades.add(new ViewGradeListItem(false, "Test 2", 1, 2, 75.0f));
            grades.add(new ViewGradeListItem(true, "Quizzes", 1, 0, 2f));
            grades.add(new ViewGradeListItem(false, "Quiz 1", 1, 1, 51.0f));
            grades.add(new ViewGradeListItem(false, "Quiz 2", 1, 2, 23.0f));
            grades.add(new ViewGradeListItem(false, "Attendance Quiz 1", 1, 3, null));
        } else {
            grades.add(new ViewGradeListItem(true, "Tests", 1, 0));
            grades.add(new ViewGradeListItem(false, "Test 1", 1, 1, 40.0f));
            grades.add(new ViewGradeListItem(true, "Labs", 1, 0, 90f));
            grades.add(new ViewGradeListItem(false, "Lab 1", 1, 1, 10.0f));
            grades.add(new ViewGradeListItem(false, "Lab 2", 1, 2, 0.0f));
            grades.add(new ViewGradeListItem(false, "Lab 3", 1, 3, 20.0f));
            grades.add(new ViewGradeListItem(true, "Assignments", 1, 0, 87f));
            grades.add(new ViewGradeListItem(false, "Homework 1", 1, 1, 76.0f));
            grades.add(new ViewGradeListItem(false, "Homework 2", 1, 2, 12.0f));
            grades.add(new ViewGradeListItem(false, "Homework 3", 1, 3, 20f));
        }


        return grades;
    }

}
