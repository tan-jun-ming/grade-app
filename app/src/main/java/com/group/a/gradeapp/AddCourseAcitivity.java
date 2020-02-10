/*
* The AddCourseActivity will help in tracking the courses being added and will be integrated into the database
 */
package com.group.a.gradeapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AddCourseAcitivity extends AppCompatActivity {

    public static final String TAG = "AddCourseActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate called");
        //On Create
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);
        


        //button is created attached to a setOnClickListener to be able to see when the button submit course is being clicked
        Button submit_button = findViewById(R.id.submit);
        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "submit clicked");
               // check_inputs();
            }
        });
    }

    //In case of error on the on click method will provide an alert dialog.
    public void alert(String error) {
        Log.d(TAG, "alerting error");
        AlertDialog.Builder builder = new AlertDialog.Builder(AddCourseAcitivity.this);
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
}
