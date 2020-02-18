package com.group.a.gradeapp.DB;

import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

public interface GradeCategoryDAO {

    @Query("select * from gradeCategoryTable")
    List<GradeCategory> getAllGradeCategories();

    @Query("select * from gradeCategoryTable where categoryID = :categoryID")
    GradeCategory getCategoryByID(int categoryID);

    @Query("select * from gradeCategoryTable where courseID = :courseID")
    List<GradeCategory> getCategoriesByCourseID(int courseID);

    @Insert
    void addGradeCategory(GradeCategory gradeCategory);
}
