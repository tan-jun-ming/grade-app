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


import java.util.Calendar;

import com.group.a.gradeapp.DB.AppDatabase;
import com.group.a.gradeapp.DB.GradeCategory;
import com.group.a.gradeapp.DB.GradeCategoryDAO;
import com.group.a.gradeapp.DB.TypeConverter.DateTypeConverter;

public class AddGradeCategoryActivity extends AppCompatActivity {
    public static final String TAG = "AddGradeCategoryAct";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_grade_category);
        final Button start_date = findViewById(R.id.start_date);
        final Button end_date = findViewById(R.id.end_date);


        Calendar c = Calendar.getInstance();

        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        start_date.setText(utils.format_date(c));
        end_date.setText(utils.format_date(c));

        final DatePickerDialog start_datepicker = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        start_date.setText(utils.format_date(year, monthOfYear, dayOfMonth));

                    }
                }, mYear, mMonth, mDay);
        final DatePickerDialog end_datepicker = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        end_date.setText(utils.format_date(year, monthOfYear, dayOfMonth));

                    }
                }, mYear, mMonth, mDay);
        start_date.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        start_datepicker.show();
                    }

                }
        );

        end_date.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        end_datepicker.show();
                    }

                }
        );

        //button is created attached to a setOnClickListener to be able to see when the button submit course is being clicked
        Button submit_button = findViewById(R.id.submit);
        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "submit clicked");

                EditText gradeCatTitle = findViewById(R.id.title);
                EditText weight = findViewById(R.id.weight);


                Integer Weight =Integer.parseInt(weight.getText().toString());
                String GradeCatTitle = gradeCatTitle.getText().toString();
                Integer courseID = 0;
                Integer AssignedDate = 02142020;


//                long Start_date = DateTypeConverter.convertDateToLong(date);
//                long End_date = DateTypeConverter.convertDateToLong(date);

                GradeCategory gradeCategory= AppDatabase.getAppDatabase(AddGradeCategoryActivity.this).
                        gradeCategoryDAO().getGradeCategoryByTitle(GradeCatTitle);

                if (gradeCategory== null) {

                    // add the new Grade Category into the database
                    GradeCategory newGradeCategory = new GradeCategory(GradeCatTitle,Weight,courseID, AssignedDate);
                    GradeCategoryDAO gradeCategoryDAO = AppDatabase.getAppDatabase(AddGradeCategoryActivity.this).gradeCategoryDAO();
                    gradeCategoryDAO.addGradeCategory(newGradeCategory);


                    //  Show in the log record that a new account was created
//                    Date now = new Date();
//                    LogRecord rec = new LogRecord(now, LogRecord.TYPE_NEW_ACCOUNT, name, "");
//                    user_dao.addLogRecord(rec);



                    // inform user that new account has been created
                    utils.display_toast(getApplicationContext(), "Grade Category created successfully", true);
                    finish();

                }

            }
        });

    }
    public void alert(String error) {
        Log.d(TAG, "alerting error");
        AlertDialog.Builder builder = new AlertDialog.Builder(AddGradeCategoryActivity.this);
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
        AlertDialog.Builder builder = new AlertDialog.Builder(AddGradeCategoryActivity.this);
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
