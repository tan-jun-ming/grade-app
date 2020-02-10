package com.group.a.gradeapp;

public class ViewGradeListItem {
    public boolean is_category;
    public String name;
    public int category_id;
    public int assignment_id;
    public Float grade;

    public ViewGradeListItem(boolean is_category, String name, int category_id, int assignment_id, Float grade){
        this.is_category = is_category;
        this.name = name;
        this.category_id = category_id;
        this.assignment_id = assignment_id;
        this.grade = grade;
    }

    public ViewGradeListItem(boolean is_category, String name, int category_id, int assignment_id){
        this(is_category, name, category_id, assignment_id, null);
    }

}
