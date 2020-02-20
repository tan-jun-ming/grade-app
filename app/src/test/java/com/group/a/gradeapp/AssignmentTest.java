package com.group.a.gradeapp;

import com.group.a.gradeapp.DB.Assignment;

import static junit.framework.TestCase.assertNotNull;

public class AssignmentTest {

    public void createAssignment(){
        Assignment assignment = new Assignment();
        assertNotNull(assignment);
    }

    public void setAssignment(){
        Assignment assignment = new Assignment();
        assignment.setAssignedDate(2020-20-20);
        assignment.setAssignmentID(1234);
        assignment.setCategoryID(234);
        assignment.setDetails("Project1");
        assignment.setDueDate(2020-20-20);

        assignment.setMaxScore(100);


    }
}
