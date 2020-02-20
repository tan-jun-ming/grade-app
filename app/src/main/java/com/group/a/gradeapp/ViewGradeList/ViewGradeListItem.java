package com.group.a.gradeapp.ViewGradeList;

/**
 * View grade list item instantiates a new View grade list item.
 */
public class ViewGradeListItem {
    /**
     * The Is category.
     */
    public boolean is_category;
    /**
     * The Name.
     */
    public String name;
    /**
     * The Category id.
     */
    public int category_id;
    /**
     * The Assignment id.
     */
    public int assignment_id;
    /**
     * The Grade.
     */
    public Float grade;

    /**
     * Instantiates a new View grade list item.
     *
     * @param is_category   the is category
     * @param name          the name
     * @param category_id   the category id
     * @param assignment_id the assignment id
     * @param grade         the grade
     */
    public ViewGradeListItem(boolean is_category, String name, int category_id, int assignment_id, Float grade){
        this.is_category = is_category;
        this.name = name;
        this.category_id = category_id;
        this.assignment_id = assignment_id;
        this.grade = grade;
    }

    /**
     * Instantiates a new View grade list item.
     *
     * @param is_category   the is category
     * @param name          the name
     * @param category_id   the category id
     * @param assignment_id the assignment id
     */
    public ViewGradeListItem(boolean is_category, String name, int category_id, int assignment_id){
        this(is_category, name, category_id, assignment_id, null);
    }

    public void set_grade(Float grade){
        this.grade = grade;
    }
    public float get_grade_total(String name){ return this.grade;}

}
