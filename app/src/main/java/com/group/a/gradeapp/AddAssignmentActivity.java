package com.group.a.gradeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

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
                    public void onClick(View v){2
                        assigneddatepicker.show();
                    }

                }
        );

    }
}
