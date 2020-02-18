package com.group.a.gradeapp.DB;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface GradeCategoryDAO {

    @Query("select * from gradeCategoryTable")
    List<GradeCategory> getAllGradeCategories();

    @Query("select * from " + AppDatabase.GRADE_CATEGORY_TABLE)
    List<GradeCategory> getGradeCategory();

    @Query("select * from gradeCategoryTable where GradeCatTitle = :GradeCatTitle")
    GradeCategory getGradeCategoryByTitle(String GradeCatTitle);

    @Insert
    void addGradeCategory(GradeCategory gradeCategory);
}
