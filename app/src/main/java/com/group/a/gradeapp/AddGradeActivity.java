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

import com.group.a.gradeapp.DB.AppDatabase;
import com.group.a.gradeapp.DB.Grade;
import com.group.a.gradeapp.DB.GradeCategory;
import com.group.a.gradeapp.DB.GradeDAO;

import java.util.Calendar;
import java.util.List;

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

        // still need to make this queries
        all_grades = AppDatabase.getAppDatabase(AddGradeActivity.this).
                gradeDAO().getAllGrades();

        all_grade_categories = AppDatabase.getAppDatabase(AddGradeActivity.this).
                gradeCategoryDAO().getAllGradeCategories();




//        final Button start_date = findViewById(R.id.assigneddate);
//        final Button end_date = findViewById(R.id.duedate);
//
//        Calendar c = Calendar.getInstance();
//
//        int mYear = c.get(Calendar.YEAR);
//        int mMonth = c.get(Calendar.MONTH);
//        int mDay = c.get(Calendar.DAY_OF_MONTH);
//
//        start_date.setText(utils.format_date(c));
//        end_date.setText(utils.format_date(c));
//
//        final DatePickerDialog start_datepicker = new DatePickerDialog(this,
//                new DatePickerDialog.OnDateSetListener() {
//
//                    @Override
//                    public void onDateSet(DatePicker view, int year,
//                                          int monthOfYear, int dayOfMonth) {
//
//                        start_date.setText(utils.format_date(year, monthOfYear, dayOfMonth));
//
//                    }
//                }, mYear, mMonth, mDay);
//        final DatePickerDialog end_datepicker = new DatePickerDialog(this,
//                new DatePickerDialog.OnDateSetListener() {
//
//                    @Override
//                    public void onDateSet(DatePicker view, int year,
//                                          int monthOfYear, int dayOfMonth) {
//
//                        end_date.setText(utils.format_date(year, monthOfYear, dayOfMonth));
//
//                    }
//                }, mYear, mMonth, mDay);
//        start_date.setOnClickListener(
//                new View.OnClickListener(){
//                    public void onClick(View v){
//                        start_datepicker.show();
//                    }
//
//                }
//        );
//        end_date.setOnClickListener(
//                new View.OnClickListener(){
//                    public void onClick(View v){
//                        end_datepicker.show();
//                    }
//
//                }
//        );
//




        //button is created attached to a setOnClickListener to be able to see when the button submit course is being clicked
        Button submit_button = findViewById(R.id.submit_button);
        submit_button.setOnClickListener(new View.OnClickListener() {

            EditText score = findViewById(R.id.score);
            Integer Score = Integer.parseInt(score.getText().toString());

            //all get the values from the spinners
            Grade assignment_spinner = (Grade) assignment_spinner.getSelectedItem();
            GradeCategory category_spinner = (GradeCategory) category_spinner.getSelectedItem();


            @Override
            public void onClick(View view) {
                Log.d(TAG, "submit clicked");




                // add the new grade into the database
                Grade newGrade = new Grade(Score, assignmentID, UserID, courseID);

                GradeDAO grade_dao = AppDatabase.getAppDatabase(AddGradeActivity.this).gradeDAO();
                grade_dao.addGrade(newGrade);


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
