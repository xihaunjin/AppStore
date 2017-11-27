package com.appStore.dao;

import com.appStore.model.Categories;
import com.appStore.model.Category;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface ICategoryDao {
    ArrayList<Category> getCategory(int id);

    ArrayList<Category> getAllCategory(@Param("start") int start, @Param("offset") int offset);

    ArrayList<Categories> getCategoryList(@Param("start") int start, @Param("offset") int offset);

    ArrayList<Category> getAllCategoryByCId(@Param("start") int start, @Param("offset") int offset, @Param("id") int id);
}
