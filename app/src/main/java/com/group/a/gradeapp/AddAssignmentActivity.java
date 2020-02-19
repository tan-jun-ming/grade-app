package com.group.a.gradeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.group.a.gradeapp.DB.AppDatabase;
import com.group.a.gradeapp.DB.Assignment;
import com.group.a.gradeapp.DB.AssignmentDAO;
import com.group.a.gradeapp.DB.Course;
import com.group.a.gradeapp.DB.CourseDAO;
import com.group.a.gradeapp.DB.GradeCategory;
import com.group.a.gradeapp.DB.TypeConverter.DateTypeConverter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * The Assignment Activity allows the user to add an assignments to the courses.
 */
public class AddAssignmentActivity extends AppCompatActivity {

    private List<Course> courses;
    private List<GradeCategory> categories;

    private String no_category_error = "Please add Grade Categories to this course before adding Assignments";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_assignment);

        courses = AppDatabase.getAppDatabase(AddAssignmentActivity.this).
                courseDAO().getCoursesAvailable();

        categories = new ArrayList<GradeCategory>();

        if (courses.size() == 0){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Error")
                    .setMessage("Please add a course before viewing this page.")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            finish();
                        }
                    });

            builder.create();
            builder.show();

            return;
        }
        int course_id = courses.get(0).getCourseID();
        update_categories(course_id);

        int category_id = -1;

        if (categories.size() > 0) {
            category_id = categories.get(0).getCategoryID();

            if (savedInstanceState == null) {
                Bundle extras = getIntent().getExtras();
                if (extras != null) {
                    category_id = extras.getInt("category_id");
                }
            } else {
                category_id = (int) savedInstanceState.getSerializable("category_id");
            }
            Log.d("1234", "" + category_id);
            GradeCategory selected_category = AppDatabase.getAppDatabase(AddAssignmentActivity.this).
                    gradeCategoryDAO().getCategoryByID(category_id);

            course_id = selected_category.getCourseID();
            update_categories(selected_category.getCourseID());
        }



        final Spinner category_spinner = findViewById(R.id.category_spinner);

        final ArrayAdapter<GradeCategory> category_adapter = new ArrayAdapter<GradeCategory>(this,
                android.R.layout.simple_spinner_item, categories);

        category_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        category_spinner.setAdapter(category_adapter);

        for (int i=0; i<categories.size(); i++) {
            if (categories.get(i).getCategoryID() == category_id) {
                category_spinner.setSelection(i);
                break;
            }
        }

        final Spinner course_spinner = findViewById(R.id.course_spinner);

        ArrayAdapter<Course> course_adapter = new ArrayAdapter<Course>(this,
                android.R.layout.simple_spinner_item, courses);

        course_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        course_spinner.setAdapter(course_adapter);

        course_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                update_categories(courses.get(position).getCourseID());
                category_adapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        for (int i=0; i<courses.size(); i++) {
            if (courses.get(i).getCourseID() == course_id) {
                course_spinner.setSelection(i);
                break;
            }
        }

        final Button duedate = findViewById(R.id.duedate);
        final Button assigneddate = findViewById(R.id.assigneddate);

        final Calendar d_c = Calendar.getInstance();
        final Calendar a_c = Calendar.getInstance();

        duedate.setText(utils.format_date(d_c));
        assigneddate.setText(utils.format_date(a_c));

        final DatePickerDialog duedatepicker = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        d_c.set(year, monthOfYear, dayOfMonth);
                        duedate.setText(utils.format_date(d_c));

                    }
                }, d_c.get(Calendar.YEAR), d_c.get(Calendar.MONTH), d_c.get(Calendar.DAY_OF_MONTH));

        final DatePickerDialog assigneddatepicker = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        a_c.set(year, monthOfYear, dayOfMonth);
                        assigneddate.setText(utils.format_date(a_c));

                    }
                }, a_c.get(Calendar.YEAR), a_c.get(Calendar.MONTH), a_c.get(Calendar.DAY_OF_MONTH));

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

        Button submit_button = findViewById(R.id.submit_button);
        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (categories.size() == 0){
                    utils.display_toast(getApplicationContext(), no_category_error);
                    return;
                }

                EditText name = findViewById(R.id.name);
                EditText detailsbox = findViewById(R.id.detailsbox);
                EditText maxscorebox = findViewById(R.id.maxscorebox);

                String assignment_name = name.getText().toString();
                String assignment_details = detailsbox.getText().toString();
                String maxscore_text = maxscorebox.getText().toString();

                if (assignment_name.equals("") || maxscore_text.equals("")){
                    alert("Please fill in the required fields.");
                    return;
                }

                int assignment_maxscore = Integer.parseInt(maxscore_text);

                long due = DateTypeConverter.convertDateToLong(d_c);
                long assigned = DateTypeConverter.convertDateToLong(a_c);

                GradeCategory selected_category = (GradeCategory) category_spinner.getSelectedItem();

                // add the new Assignment into the database
                Assignment new_assignment = new Assignment(assignment_name, assignment_details, assignment_maxscore, selected_category.getCategoryID(), assigned, due);
                AssignmentDAO assignmentDAO = AppDatabase.getAppDatabase(AddAssignmentActivity.this).assignmentDAO();
                assignmentDAO.addAssignment(new_assignment);

                utils.display_toast(getApplicationContext(), "Assignment " + assignment_name + " added successfully");
                finish();
            }
        });
    }

    private void update_categories(int course_id){
        categories.clear();
        List<GradeCategory> new_categories = AppDatabase.getAppDatabase(AddAssignmentActivity.this).
                gradeCategoryDAO().getCategoriesByCourseID(course_id);
        categories.addAll(new_categories);

        if (categories.size() == 0){
            alert(no_category_error + ".");
        }
    }

    private void alert(String msg){
        AlertDialog.Builder builder = new AlertDialog.Builder(AddAssignmentActivity.this);
        builder.setTitle("Error");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.setMessage(msg);
        dialog.show();
    }
}
