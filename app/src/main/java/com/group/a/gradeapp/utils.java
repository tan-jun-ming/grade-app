package com.group.a.gradeapp;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.widget.Toast;

import java.util.Calendar;

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

    public static String format_date(Calendar c){
        return format_date(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));

    }

    public static String format_date(int year, int month, int day){
        return String.format("%04d-%02d-%02d", year, month+1, day);
    }
}
