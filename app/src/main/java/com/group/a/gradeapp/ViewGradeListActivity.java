package com.group.a.gradeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.group.a.gradeapp.DB.AppDatabase;
import com.group.a.gradeapp.DB.Assignment;
import com.group.a.gradeapp.DB.Course;
import com.group.a.gradeapp.DB.Grade;
import com.group.a.gradeapp.DB.GradeCategory;
import com.group.a.gradeapp.ViewGradeList.RecyclerItemClickListener;
import com.group.a.gradeapp.ViewGradeList.ViewGradeListAdapter;
import com.group.a.gradeapp.ViewGradeList.ViewGradeListItem;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViewGradeListActivity extends AppCompatActivity {

    private ViewGradeListAdapter grade_adapter;
    private ArrayList<ViewGradeListItem> grades;
    private Course selected_course;
    private List<Course> course_array;

    int user_id = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_grade_list);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras != null) {
                user_id = extras.getInt("user_id");
            }
        } else {
            user_id = (int) savedInstanceState.getSerializable("user_id");
        }

        course_array = get_course_array();

        if (course_array.size() == 0){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Error")
                .setMessage("Please Enroll in a course before viewing this page.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                });

            builder.create();
            builder.show();

            return;
        }

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

        ArrayAdapter<Course> adapter = new ArrayAdapter<Course>(this,
                android.R.layout.simple_spinner_item, course_array);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        course_spinner.setAdapter(adapter);

        course_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                selected_course = course_array.get(position);
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
                intent.putExtra("course_id", selected_course.getCourseID());
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
        grades = get_grades(selected_course.getCourseID());
        grade_adapter.update(grades);
    }

    List<Course> get_course_array(){

        return AppDatabase.getAppDatabase(ViewGradeListActivity.this).
                courseDAO().getCoursesByUser(user_id);


    }


    /**
     * Opens the assigment or category at the position as a Grade Summary or Add Assignment Activity
     *
     * @param position Position of the item in the recycler
     */
    private void open_assignment(int position){
        ViewGradeListItem item = grades.get(position);

        if (item.is_category){
            if (item.category_id != -1){ // Total case
                // open add assignment activity
                Intent intent = new Intent(ViewGradeListActivity.this, AddAssignmentActivity.class);
                intent.putExtra("category_id", item.category_id);
                startActivity(intent);
            }
        } else {
            // open add grade activity
            Intent intent = new Intent(ViewGradeListActivity.this, AddGradeActivity.class);
            intent.putExtra("user_id", user_id);
            intent.putExtra("course_id", selected_course.getCourseID());
            intent.putExtra("assignment_id", item.assignment_id);
            intent.putExtra("course_name", selected_course.getTitle());
            intent.putExtra("assignment_name", item.name);
            startActivity(intent);
        }

    }

    /**
     * Gets the category and assignment grades from the database
     *
     * @return ArrayList of ViewGradeListItem for displaying in the recycler
     */
    private ArrayList<ViewGradeListItem> get_grades(int selected_course_id){
        ArrayList<ViewGradeListItem> grades = new ArrayList<ViewGradeListItem>();

        List<GradeCategory> categories = AppDatabase.getAppDatabase(ViewGradeListActivity.this).
                gradeCategoryDAO().getCategoriesByCourseID(selected_course_id);

        List<Grade> grade_list = AppDatabase.getAppDatabase(ViewGradeListActivity.this).
                gradeDAO().getGradesByCourseIDAndUserID(selected_course_id, user_id);


        Map<Integer, Integer> grades_map = new HashMap<Integer, Integer>();

        for (Grade g: grade_list){
            grades_map.put(g.getAssignmentID(), g.getScore());
        }

        ArrayList<Pair<Float, Float>> grade_scores = new ArrayList<>();
        float max_weight = 0;

        for (GradeCategory c: categories){
            ViewGradeListItem cat = new ViewGradeListItem(true, c.getTitle(), c.getCategoryID(), -1, null);
            grades.add(cat);

            int max_category_score = 0;
            int earned_category_score = 0;

            List<Assignment> assignments = AppDatabase.getAppDatabase(ViewGradeListActivity.this).
                    assignmentDAO().getAssignmentsByCategory(c.getCategoryID());

            for (Assignment a: assignments){
                int a_max = a.getMaxScore();
                max_category_score += a_max;

                Integer a_earned = grades_map.get(a.getAssignmentID());

                Float earned_percentage = null;
                if (a_earned == null){
                    a_earned = 0;
                } else {
                    earned_percentage = utils.calculate_percentage(a_earned, a_max);
                }
                grades.add(new ViewGradeListItem(false, a.getAssTitle(), a.getCategoryID(), a.getAssignmentID(), earned_percentage));

                earned_category_score += a_earned;
            }
            float category_percentage = utils.calculate_percentage(earned_category_score, max_category_score);
            cat.set_grade(category_percentage);

            max_weight += c.getWeight();
            grade_scores.add(Pair.create(c.getWeight(), category_percentage));

        }

        Float total_percentage = null;
        if (max_weight != 0){
            total_percentage = 0f;
            for (Pair<Float, Float> s: grade_scores){
                total_percentage += (s.first/max_weight) * s.second;
            }
        }

        grades.add(new ViewGradeListItem(true, "Total", -1, -1, total_percentage));
        return grades;
    }

}