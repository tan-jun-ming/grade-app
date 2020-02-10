package com.group.a.gradeapp;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.widget.Toast;

public class utils {
    public static void display_toast(Context intent_context, String message){
        Toast.makeText(intent_context, message,
                Toast.LENGTH_LONG).show();
    }

    public static int dp_to_pixels(int dp){
        return (int)(dp * Resources.getSystem().getDisplayMetrics().density);
    }
}
