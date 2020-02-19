package com.group.a.gradeapp;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.widget.Toast;

import java.util.Calendar;

public class utils {
    /**
     * Display a toast
     *
     * @param intent_context Context of the intent
     * @param message Message to display
     */
    public static void display_toast(Context intent_context, String message){
        display_toast(intent_context, message, false);
    }

    /**
     * Display a toast
     *
     * @param intent_context Context of the intent
     * @param message Message to display
     * @param long_duration Whether or not the duration of the toast is long
     */
    public static void display_toast(Context intent_context, String message, boolean long_duration){
        Toast.makeText(intent_context, message,
                long_duration ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT).show();
    }

    /**
     * Converts dp to pixels
     *
     * @param dp The dp to convert
     * @return The amount in pixels
     */
    public static int dp_to_pixels(int dp){
        return (int)(dp * Resources.getSystem().getDisplayMetrics().density);
    }

    /**
     * Formats a Calendar object to a date string
     *
     * @param c The Calendar object to format
     * @return The date string
     */
    public static String format_date(Calendar c){
        return format_date(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));

    }

    /**
     * Formats year, month and day to a date string
     *
     * @param year The year
     * @param month The month (zero-indexed)
     * @param day The day
     * @return The date string
     */
    public static String format_date(int year, int month, int day){
        return String.format("%04d-%02d-%02d", year, month+1, day);
    }

    /**
     * Calculates the percentage of two floats
     *
     * @param numerator The numerator
     * @param denominator The denominator
     * @return The percentage
     */
    public static float calculate_percentage(float numerator, float denominator){
        return denominator == 0 ? 0 :(numerator/denominator) * 100;
    }
}
