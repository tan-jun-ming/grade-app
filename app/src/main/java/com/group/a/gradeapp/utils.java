package com.group.a.gradeapp;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.widget.Toast;

public class utils {
    public static void display_toast(Context intent_context, String message){
        display_toast(intent_context, message, false);
    }

    public static void display_toast(Context intent_context, String message, boolean long_duration){
        Toast.makeText(intent_context, message,
                long_duration ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT).show();
    }

    public static int dp_to_pixels(int dp){
        return (int)(dp * Resources.getSystem().getDisplayMetrics().density);
    }
}
