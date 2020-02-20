package com.group.a.gradeapp;

import android.content.Context;

import androidx.test.rule.ActivityTestRule;

import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;


import org.junit.runner.Runner;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class LoginActivityTest {
    @Rule
    public ActivityTestRule<LoginActivity> mActivityTestRule = new ActivityTestRule<LoginActivity>(LoginActivity.class);
    private MenuActivity mActivity= null;
    //if the result the user input isEqualsTo an empty string it does not pass the test.
    private static final String FAKE_STRING = "";


    @RunWith(MockitoJUnitRunner.class)
    public class LoginUnitTest {

        private static final String FAKE_STRING = "Login was successful";

        @Mock
        Context mMockContext;

        @Test
        public void readStringFromContext_LocalizedString() {

            //LoginActivity myObjectUnderTest = new LoginActivity(mMockContext);

            // ...when the string is returned from the object under test...
           // String result = myObjectUnderTest.validate("username","password");

            // ...then the result should be the expected one.
            //assertThat(result, is(FAKE_STRING));
        }

    }
}