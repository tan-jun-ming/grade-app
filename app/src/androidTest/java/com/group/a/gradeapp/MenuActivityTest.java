package com.group.a.gradeapp;

import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import java.lang.Object;
import androidx.test.rule.ActivityTestRule;


import static org.junit.Assert.*;

/**
 * The type Menu activity test is to be able to test the Main Activity.
 */
public class MenuActivityTest {


    @Rule
    public ActivityTestRule<MenuActivity> mActivityTestRule = new ActivityTestRule<MenuActivity>(MenuActivity.class);
    private MenuActivity mActivity= null;


    /**
     * Sets up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();
    }

    /**
     * Test launch.
     */
    @Test
    public void testLaunch(){
        View view = mActivity.findViewById(R.id.textView);
        assertNotNull(view);
    }

    /**
     * Creates a test for buttons
     * @throws Exception
     */


    /**
     * Tear down.
     *
     * @throws Exception the exception
     */
    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }
}