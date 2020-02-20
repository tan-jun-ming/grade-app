package com.group.a.gradeapp;

import com.group.a.gradeapp.DB.Assignment;

import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

public class AssignmentTest {

    @Test
    public void createAssignment(){
        Assignment assignment = new Assignment();
        assertNotNull(assignment);
    }

    @Test
    public void setAssignment(){
        Assignment assignment = new Assignment();
        assignment.setAssignedDate(2020-20-20);
        assignment.setAssignmentID(1234);
        assignment.setCategoryID(234);
        assignment.setDetails("Project1");
        assignment.setDueDate(2020-20-20);

        assignment.setMaxScore(100);
        assertTrue(assignment.getAssignedDate() ==2020-20-20 &&
                assignment.getAssignmentID() == 1234 &&
                assignment.getCategoryID() == 234 &&
                assignment.getDetails() == "Project1" &&
                assignment.getDueDate() == 2020-20-20);

    }
}
