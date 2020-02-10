package com.group.a.gradeapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("LoginActivity", "onCreate called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button login_button = findViewById(R.id.login_button);
        login_button.setOnClickListener(new View.OnClickListener() {
            //calls the onclick method 
            //will ask username and password on page
            @Override
            public void onClick(View v) {

                EditText username = findViewById(R.id.username);
                EditText password = findViewById(R.id.password);


                String name = username.getText().toString();
                String pw = password.getText().toString();

                Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                startActivity(intent);

//                FlightDao dao = FlightRoom.getFlightRoom(LoginActivity.this).dao();
//                User user = dao.login(name, pw);
//                if (user == null) {
//                    // unsuccessful login
//                    TextView msg = findViewById(R.id.message);
//                    msg.setText("User name or password is invalid.");
//
//                } else {
//                    // successful login
//                    MainActivity.username = username.getText().toString();
//                    finish();
//                }


            }
        });

    }


}
