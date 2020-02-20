package com.group.a.gradeapp;
import com.group.a.gradeapp.DB.Enrollment;

import static junit.framework.TestCase.assertNotNull;

public class EnrollmentTest {

    public void createEnrollment(){
        Enrollment enrollment = new Enrollment();
        assertNotNull(enrollment);
    }

    public void setEnrollment(){
        Enrollment enrollment = new Enrollment();
        enrollment.setCourseID(234);
        enrollment.setUserID(22);
    }
}
