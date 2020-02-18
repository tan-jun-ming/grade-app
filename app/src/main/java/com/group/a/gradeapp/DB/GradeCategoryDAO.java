package com.group.a.gradeapp.DB;

import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

public interface GradeCategoryDAO {

    @Query("select * from gradeCategoryTable")
    List<GradeCategory> getAllGradeCategories();

    @Query("select * from " + AppDatabase.GRADE_CATEGORY_TABLE)
    List<GradeCategory> getGradeCategory();

    @Query("select * from gradeCategoryTable where categoryID = :categoryID")
    Course getCategoryByID(int categoryID);

    @Insert
    void addGradeCategory(GradeCategory gradeCategory);
}
