package com.group.a.gradeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        final Button button = findViewById(R.id.create_account_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                create_account();
            }
        });
    }

    public boolean create_account(){
        final EditText username = findViewById(R.id.username);
        final EditText password = findViewById(R.id.password);

        return create_account(username.getText().toString(), password.getText().toString());
    }

    public boolean create_account(String username, String password){
        // access database here
        return true;
    }
}
