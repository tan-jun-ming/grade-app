package com.group.a.gradeapp;

import com.group.a.gradeapp.DB.User;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class unitUserTest {


    @Test
    public void createUser(){
        User user = new User();
        assertNotNull(user);
    }


    @Test
    public void setUser(){
        User user = new User();

        user.setUsername("groupA");
        user.setPassword("testing");
        user.setFirst_name("Chester");
        user.setLast_name("Mcbadbat");

        assertTrue(user.getUsername() == "groupA" && user.getPassword() == "testing");
    }
}
