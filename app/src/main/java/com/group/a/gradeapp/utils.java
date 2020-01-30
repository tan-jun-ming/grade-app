package com.group.a.gradeapp;

import android.content.Context;
import android.widget.Toast;

public class utils {
    public static void display_toast(Context intent_context, String message){
        Toast.makeText(intent_context, message,
                Toast.LENGTH_LONG).show();
    }
}
