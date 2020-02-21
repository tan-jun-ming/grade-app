package com.group.a.gradeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
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


public class ViewGradeSummaryActivity extends AppCompatActivity {
    public static final String TAG = "ViewGradeSummaryAct";

    private ViewGradeListAdapter adapter;
    private List<Course> course_array;



    private ArrayList<ViewGradeListItem> grades;
    private Course selected_course;
    int user_id = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_grade_summary);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras != null) {
                user_id = extras.getInt("user_id");
            }
        } else {
            user_id = (int) savedInstanceState.getSerializable("user_id");
        }
        Log.d(TAG, "2727" + user_id);


        RecyclerView recycler_view = findViewById(R.id.view_courses);

        RecyclerView.LayoutManager layout_manager = new LinearLayoutManager(this);
        recycler_view.setLayoutManager(layout_manager);


        RecyclerItemClickListener listener = new RecyclerItemClickListener() {
            @Override
            public void onClick(View view, int position) {
            }
        };

        adapter = new ViewGradeListAdapter(listener);
        recycler_view.setAdapter(adapter);

        // retrieve all courses the user is in
        ArrayList<ViewGradeListItem> course_array = new ArrayList<>();

        for (Course c: get_course_array()){
            course_array.add(new ViewGradeListItem(true, c.getTitle(), -1, -1, get_grade_percentage(c.getCourseID())));
        }

        adapter.update(course_array);

        Log.d(TAG, "2725" + course_array.toString());

    }

    List<Course> get_course_array(){

        return AppDatabase.getAppDatabase(ViewGradeSummaryActivity.this).
                courseDAO().getCoursesByUser(user_id);


    }


    /**
     * Gets the category and assignment grades from the database
     *
     * @return ArrayList of ViewGradeListItem for displaying in the recycler
     */
    private Float get_grade_percentage(int selected_course_id){

        List<GradeCategory> categories = AppDatabase.getAppDatabase(ViewGradeSummaryActivity.this).
                gradeCategoryDAO().getCategoriesByCourseID(selected_course_id);

        List<Grade> grade_list = AppDatabase.getAppDatabase(ViewGradeSummaryActivity.this).
                gradeDAO().getGradesByCourseIDAndUserID(selected_course_id, user_id);


        Map<Integer, Integer> grades_map = new HashMap<Integer, Integer>();

        for (Grade g: grade_list){
            grades_map.put(g.getAssignmentID(), g.getScore());
        }

        ArrayList<Pair<Float, Float>> grade_scores = new ArrayList<>();
        float max_weight = 0;

        for (GradeCategory c: categories){

            int max_category_score = 0;
            int earned_category_score = 0;

            List<Assignment> assignments = AppDatabase.getAppDatabase(ViewGradeSummaryActivity.this).
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

                earned_category_score += a_earned;
            }
            float category_percentage = utils.calculate_percentage(earned_category_score, max_category_score);

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

        return total_percentage;
    }
}


