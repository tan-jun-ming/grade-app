package com.group.a.gradeapp;

import org.junit.Test;

import java.util.Calendar;
import java.util.Random;

import static junit.framework.TestCase.assertEquals;

public class UtilsTests {
    @Test
    public void format_date() {
        Calendar c = Calendar.getInstance();
        int y_min = 0;
        int y_max = 10000;

        int m_min = 0;
        int m_max = 12;

        int d_min = 1;
        int d_max = 28;

        Random random = new Random();

        int year = random.nextInt((y_max - y_min) + 1) + y_min;
        int month = random.nextInt((m_max - m_min) + 1) + m_min;
        int day = random.nextInt((d_max - d_min) + 1) + d_min;

        c.set(year, month, day);

        assertEquals(utils.format_date(c), String.format("%04d-%02d-%02d", year, month+1, day));
    }
}
