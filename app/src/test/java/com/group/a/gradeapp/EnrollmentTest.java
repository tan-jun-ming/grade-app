package com.group.a.gradeapp;
import com.group.a.gradeapp.DB.Enrollment;

import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

public class EnrollmentTest {

    @Test
    public void createEnrollment(){
        Enrollment enrollment = new Enrollment();
        assertNotNull(enrollment);
    }

    @Test
    public void setEnrollment(){
        Enrollment enrollment = new Enrollment();
        enrollment.setCourseID(234);
        enrollment.setUserID(22);

        assertTrue(enrollment.getCourseID() == 234 && enrollment.getUserID() == 22);

    }
}
