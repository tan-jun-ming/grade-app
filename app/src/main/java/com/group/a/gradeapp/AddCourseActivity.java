/*
* The AddCourseActivity will help in tracking the courses being added and will be integrated into the database
 */
package com.group.a.gradeapp;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.group.a.gradeapp.DB.AppDatabase;
import com.group.a.gradeapp.DB.Course;
import com.group.a.gradeapp.DB.CourseDAO;
import com.group.a.gradeapp.DB.TypeConverter.DateTypeConverter;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AddCourseActivity extends AppCompatActivity {

    public static final String TAG = "AddCourseActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate called");
        //On Create
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);



        Button start_date = findViewById(R.id.start_date);
        Button end_date = findViewById(R.id.end_date);


        Calendar c = Calendar.getInstance();

        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        final Date date= new Date();

        start_date.setText(utils.format_date(c));
        end_date.setText(utils.format_date(c));

        final DatePickerDialog start_datepicker = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    Button start_date = findViewById(R.id.start_date);


                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        start_date.setText(utils.format_date(year, monthOfYear, dayOfMonth));

                    }
                }, mYear, mMonth, mDay);
        final DatePickerDialog end_datepicker = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    Button end_date = findViewById(R.id.end_date);

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
               // check_inputs();


                EditText instructorName = findViewById(R.id.Instructor);


                String InstructorName = instructorName.getText().toString();
                long Start_date = DateTypeConverter.convertDateToLong(date);
                long End_date = DateTypeConverter.convertDateToLong(date);

                Course course = AppDatabase.getAppDatabase(AddCourseActivity.this).
                        courseDAO().getCourseByID(course_Id);

                if (course== null) {

                    // add the new course into the database
                    Course newCourse = new Course(InstructorName, Title, Description, Start_date, End_date, course_Id);
                    CourseDAO course_dao = AppDatabase.getAppDatabase(AddCourseActivity.this).courseDAO();
                    course_dao.addCourse(newCourse);


                    //  Show in the log record that a new account was created
//                    Date now = new Date();
//                    LogRecord rec = new LogRecord(now, LogRecord.TYPE_NEW_ACCOUNT, name, "");
//                    user_dao.addLogRecord(rec);



                    // inform user that new account has been created
                    utils.display_toast(getApplicationContext(), "Course created successfully", true);
                    finish();

                }
            }
        });
    }

    //In case of error on the on click method will provide an alert dialog.
    public void alert(String error) {
        Log.d(TAG, "alerting error");
        AlertDialog.Builder builder = new AlertDialog.Builder(AddCourseActivity.this);
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
        AlertDialog.Builder builder = new AlertDialog.Builder(AddCourseActivity.this);
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
