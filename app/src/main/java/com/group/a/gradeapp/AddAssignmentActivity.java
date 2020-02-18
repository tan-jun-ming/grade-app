package com.group.a.gradeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.group.a.gradeapp.DB.AppDatabase;
import com.group.a.gradeapp.DB.Assignment;
import com.group.a.gradeapp.DB.AssignmentDAO;

import java.util.Calendar;

public class AddAssignmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_assignment);

        String category_name = "";

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras != null) {
                category_name = extras.getString("category_name");
            }
        } else {
            category_name = (String) savedInstanceState.getSerializable("category_name");
        }

        final Button duedate = findViewById(R.id.duedate);
        final Button assigneddate = findViewById(R.id.assigneddate);

        TextView categoryname = findViewById(R.id.categoryname);
        categoryname.setText(category_name);

        Calendar c = Calendar.getInstance();

        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        duedate.setText(utils.format_date(c));
        assigneddate.setText(utils.format_date(c));

        final DatePickerDialog duedatepicker = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        ;
                        duedate.setText(utils.format_date(year, monthOfYear, dayOfMonth));

                    }
                }, mYear, mMonth, mDay);

        final DatePickerDialog assigneddatepicker = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        assigneddate.setText(utils.format_date(year, monthOfYear, dayOfMonth));

                    }
                }, mYear, mMonth, mDay);

        duedate.setOnClickListener(
            new View.OnClickListener(){
                public void onClick(View v){
                    duedatepicker.show();
                }

            }
        );

        assigneddate.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        assigneddatepicker.show();
                    }

                }
        );



        Button submit_button = findViewById(R.id.submit);
        submit_button.setOnClickListener(new View.OnClickListener() {


            EditText title = findViewById(R.id.title);
            EditText description = findViewById(R.id.detailsbox);
            Spinner categorySpinner= findViewById(R.id.categoryspinner);
            EditText maxScore = findViewById(R.id.maxscorebox);
            EditText earnedScore = findViewById(R.id.maxscorebox2);


            String AssTitle = title.getText().toString();
            String Details = description.getText().toString();
            Integer MaxScore =Integer.parseInt(maxScore.getText().toString());
            Integer EarnedScore =Integer.parseInt(earnedScore.getText().toString());
            Integer CategorySpinner = Integer.parseInt(categorySpinner.getSelectedItem().toString());


            @Override
            public void onClick(View view) {

                Assignment assignment= AppDatabase.getAppDatabase(AddAssignmentActivity.this).
                        assignmentDAO().getAssignmentByTitle(AssTitle);


                if (assignment == null) {

                    // add the new user account into the database
                    Assignment newAssignment = new Assignment(AssTitle, Details, MaxScore, EarnedScore, CategorySpinner);


                    AssignmentDAO assignment_dao = AppDatabase.getAppDatabase(AddAssignmentActivity.this).assignmentDAO();
                    assignment_dao.addAssignment(newAssignment);


                    //  Show in the log record that a new account was created
//                    Date now = new Date();
//                    LogRecord rec = new LogRecord(now, LogRecord.TYPE_NEW_ACCOUNT, name, "");
//                    user_dao.addLogRecord(rec);

                    // inform user that new account has been created
                    utils.display_toast(getApplicationContext(), "Assignment added successfully", true);
                    finish();
                }

            }
        });









    }
}
