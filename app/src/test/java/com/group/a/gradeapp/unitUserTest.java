package com.group.a.gradeapp;

import com.group.a.gradeapp.DB.User;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class unitUserTest {


    public void createUser(){
        User user = new User();
        assertNotNull(user);
    }


    public void setUser(){
        User user = new User();

        user.setUsername("groupA");
        user.setPassword("testing");
        user.setFirst_name("Chester");
        user.setLast_name("Mcbadbat");

        assertTrue(user.getUsername() == "groupA" && user.getPassword() == "testing");
    }
}
