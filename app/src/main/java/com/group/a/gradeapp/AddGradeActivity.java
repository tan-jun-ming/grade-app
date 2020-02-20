package com.group.a.gradeapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.group.a.gradeapp.DB.AppDatabase;
import com.group.a.gradeapp.DB.Assignment;
import com.group.a.gradeapp.DB.Grade;
import com.group.a.gradeapp.DB.GradeCategory;
import com.group.a.gradeapp.DB.GradeDAO;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The add grade activity will integrate grades onto the database.
 */

public class AddGradeActivity extends AppCompatActivity {
    public static final String TAG = "AddGradeActivity";
    private List<Grade> all_grades;
    private List<GradeCategory> all_grade_categories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_grade);
        final AtomicInteger user_id = new AtomicInteger(-1);
        final AtomicInteger course_id = new AtomicInteger(-1);
        int assignment_id = -1;
        String course_name = "";

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras != null) {
                user_id.set(extras.getInt("user_id"));
                course_id.set(extras.getInt("course_id"));
                assignment_id = extras.getInt("assignment_id");
                course_name = extras.getString("course_name");
            }
        } else {
            user_id.set((int) savedInstanceState.getSerializable("user_id"));
            course_id.set((int) savedInstanceState.getSerializable("course_id"));
            assignment_id = (int) savedInstanceState.getSerializable("assignment_id");
            course_name = (String) savedInstanceState.getSerializable("course_name");
        }

        if (assignment_id == -1){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Error")
                    .setMessage("Please visit this page via the Grade List.\n\nSomeone please remove the button that leads here too plz.")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.dismiss();
                        }
                    });

            builder.create();
            builder.show();

            return;
        }

        TextView coursename = findViewById(R.id.coursename);
        TextView assignmentname = findViewById(R.id.assignmentname);
        TextView max_score = findViewById(R.id.max_score);
        final EditText score = findViewById(R.id.score);

        coursename.setText(course_name);

        final Assignment assignment = AppDatabase.getAppDatabase(AddGradeActivity.this).
                assignmentDAO().getAssignmentByID(assignment_id);

        assignmentname.setText(assignment.getAssTitle());
        max_score.setText(Integer.toString(assignment.getMaxScore()));

        Grade grade = AppDatabase.getAppDatabase(AddGradeActivity.this).
                gradeDAO().getGradeByAssignmentIDAndUserID(assignment_id, user_id.get());

        final AtomicBoolean updating = new AtomicBoolean(false);
        if (grade != null){
            score.setText(Integer.toString(grade.getScore()));
            updating.set(true);
        }

        // print details from assignment toString
        String assignmentDetails= assignment.toString();
        TextView assignment_detials = findViewById(R.id.assignmentdetails);
        assignment_detials.setText(assignmentDetails);

        //button is created attached to a setOnClickListener to be able to see when the button submit course is being clicked
        Button submit_button = findViewById(R.id.submit_button);
        submit_button.setOnClickListener(new View.OnClickListener() {

//            EditText score = findViewById(R.id.score);
//            Integer Score = Integer.parseInt(score.getText().toString());
//
//            //all get the values from the spinners
//            Grade assignment_spinner = (Grade) assignment_spinner.getSelectedItem();
//            GradeCategory category_spinner = (GradeCategory) category_spinner.getSelectedItem();


            @Override
            public void onClick(View view) {
                Log.d(TAG, "submit clicked");

                String grade_score_text = score.getText().toString();

                if (grade_score_text.equals("")) {
                    alert("Please enter a score.");
                    return;
                }

                int grade_score = Integer.parseInt(grade_score_text);

                if (grade_score > assignment.getMaxScore()){
                    alert("Please enter a score below the maximum.");
                    return;
                }

                // add the new grade into the database
                Grade newGrade = new Grade(grade_score, assignment.getAssignmentID(), user_id.get(), course_id.get());
                GradeDAO grade_dao = AppDatabase.getAppDatabase(AddGradeActivity.this).gradeDAO();

                if (updating.get()){
                    grade_dao.update(newGrade);
                } else {
                    grade_dao.addGrade(newGrade);
                }

                utils.display_toast(getApplicationContext(), "Your grade was set");
                finish();

            }
        });


    }
    public void alert(String error) {
        Log.d(TAG, "alerting error");
        AlertDialog.Builder builder = new AlertDialog.Builder(AddGradeActivity.this);
        builder.setTitle("Error");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.setMessage(error);
        dialog.show();
    }
    //informs user
    public void inform(String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(AddGradeActivity.this);
        builder.setTitle("Success");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                finish();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.setMessage(msg);
        dialog.show();
    }

}
