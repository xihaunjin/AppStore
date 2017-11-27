package com.appStore.service.impl;

import com.appStore.dao.ICategoryDao;
import com.appStore.model.Categories;
import com.appStore.service.ICategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service("categoryService")


public class CategoryServiceImpl implements ICategoryService{
    @Resource
    private ICategoryDao categoryDao;

    public ArrayList<Categories> getCategoryList(int start, int offset) {
        ArrayList<Categories> categoryList = this.categoryDao.getCategoryList(start,offset);
        return categoryList;
    }
}
