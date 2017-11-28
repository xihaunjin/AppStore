package com.appStore.service.impl;


import com.appStore.model.*;
import com.appStore.dao.IAppDao;
import com.appStore.dao.ICategoryDao;
import com.appStore.dao.IImageDao;

import com.appStore.service.IAppService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service("appService")
public class AppServiceImpl implements IAppService {
    @Resource
    private IAppDao appDao;
    @Resource
    private IImageDao imageDao;
    @Resource
    private ICategoryDao categoryDao;

    public AppMessage getAppMessage(int id) {
        ArrayList<Category> categories = this.categoryDao.getCategory(id);
        ArrayList<Image> images = this.imageDao.getImage(id);
        App app = this.appDao.getApp(id);
        AppMessage appMessage = new AppMessage();
        appMessage.setApp(app);
        appMessage.setImages(images);
        appMessage.setCategories(categories);
        return appMessage;
    }


    public ArrayList<AppMessage> getAllAppMessage(int start, int offset) {
        ArrayList<App> apps = appDao.getAllApp(start, offset);
        ArrayList<Image> images = imageDao.getAllImage(start, offset);
        ArrayList<Category> categories = categoryDao.getAllCategory(start, offset);
        ArrayList<AppMessage> appMessages = new ArrayList<AppMessage>();
        AppMessage.ConnectMessages(appMessages, apps, categories, images);

        return appMessages;
    }

}
