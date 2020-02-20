package com.group.a.gradeapp;

import com.group.a.gradeapp.DB.Course;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class courseTest {

    public void createCourse(){
        Course course = new Course();

        assertNotNull(course);
    }

    public void setCourse(){
        Course course = new Course();
        course.setCourseID(438);
        course.setDescription("Software Engineering");
        course.setTitle("CST 438");
        course.setInstructor("Drew");

        assertTrue(course.getCourseID() == 438 &&
                course.getDescription() == "Software Engineering" && course.getTitle() == "CST 438"
                && course.getInstructor() == "Drew");
    }
}
