package com.appStore.service;

import com.appStore.model.Categories;

import java.util.ArrayList;

public interface ICategoryService {
    ArrayList<Categories> getCategoryList(int start, int offset);
}
