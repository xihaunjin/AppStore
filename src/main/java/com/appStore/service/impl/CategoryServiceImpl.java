package com.appStore.service.impl;

import com.appStore.dao.IAppDao;
import com.appStore.dao.ICategoryDao;
import com.appStore.dao.IImageDao;
import com.appStore.model.*;
import com.appStore.service.ICategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service("categoryService")


public class CategoryServiceImpl implements ICategoryService{
    @Resource
    private ICategoryDao categoryDao;
    @Resource
    private IAppDao appDao;
    @Resource
    private IImageDao imageDao;

    public ArrayList<Categories> getCategoryList(int start, int offset) {
        ArrayList<Categories> categoryList = this.categoryDao.getCategoryList(start,offset);
        return categoryList;
    }

    public ArrayList<AppMessage> getAppMessageByCId(int start, int offset, int id)
    {
        ArrayList<App> apps=appDao.getAllAppByCId(start,offset,id);
        ArrayList<Image> images=imageDao.getAllImageByCId(start,offset,id);
        ArrayList<Category> categories=categoryDao.getAllCategoryByCId(start,offset,id);
        ArrayList<AppMessage> appMessages=new ArrayList<AppMessage>();
        AppMessage.ConnectMessages(appMessages,apps,categories,images);
        return appMessages;
    }
}
