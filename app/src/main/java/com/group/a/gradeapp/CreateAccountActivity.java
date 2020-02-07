//package com.group.a.gradeapp;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import static android.app.PendingIntent.getActivity;
//
//public class CreateAccountActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_create_account);
//
//        final Button button = findViewById(R.id.create_account_button);
//        button.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                create_account();
//            }
//        });
//    }
//
//    public void create_account(){
//        final EditText username = findViewById(R.id.username);
//        final EditText password = findViewById(R.id.password);
//        final EditText firstname = findViewById(R.id.firstname);
//        final EditText lastname = findViewById(R.id.lastname);
//
//        boolean result = create_account(username.getText().toString(), password.getText().toString(), firstname.getText().toString(), lastname.getText().toString());
//        String notify_string = result ? "Account Created Successfully" : "Account Creation Failed";
//
//        utils.display_toast(this, notify_string);
//
//        if (result) {
//            finish();
//        }
//
//    }
//
//    public boolean create_account(String username, String password, String firstname, String lastname){
//        // access database here
//        return true;
//    }
//}
