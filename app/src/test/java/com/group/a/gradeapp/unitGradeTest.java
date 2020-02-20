package com.group.a.gradeapp;

import com.group.a.gradeapp.DB.Grade;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class unitGradeTest {

    @Test
    public void GradeTest(){
        Grade grade = new Grade();
        assertNotNull(grade);
    }

    @Test
    public void setGrade(){
        Grade grade = new Grade();

    }
}
