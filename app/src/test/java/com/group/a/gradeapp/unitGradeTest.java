package com.group.a.gradeapp;

import com.group.a.gradeapp.DB.Grade;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class unitGradeTest {

    public void GradeTest(){
        Grade grade = new Grade();
        assertNotNull(grade);
    }

    public void setGrade(){
        Grade grade = new Grade();
        grade.setGradeID(23);
        assertTrue(grade.getGradeID() == 23);
    }
}
