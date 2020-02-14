package com.group.a.gradeapp.CourseSpinner;

import com.group.a.gradeapp.DB.Course;

public class CourseListItem {

    public int course_id;
    public String name;

    public CourseListItem(int course_id, String name){
        this.course_id = course_id;
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }


}
