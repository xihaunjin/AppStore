package com.appStore.model;

import java.util.ArrayList;

public class AppMessage {
    private App app;
    private ArrayList<Image> images;
    private ArrayList<Category> categories;

    private MyException exception;

    public static void ConnectMessages(ArrayList<AppMessage> appMessages,
                                       ArrayList<App> apps, ArrayList<Category> categories, ArrayList<Image> images) {
        boolean isStart = false;
        for (App app : apps) {
            AppMessage appMessage = new AppMessage();
            ArrayList<Category> categoriesPre = new ArrayList<Category>();
            ArrayList<Image> imagesPre = new ArrayList<Image>();
            appMessage.setApp(app);
            //找到categories.appId==app.id的起始点,将结点加入appMessages并在categories删除
            isStart = false;
            for (Category category : categories) {
                if (category.getAppId() == app.getId()) {
                    if (!isStart) isStart = true;
                    categoriesPre.add(category);

                } else if (isStart && app.getId() != category.getAppId()) break;
            }

            isStart = false;
            for (Image image : images) {
                if (app.getId() == image.getAppId()) {
                    if (!isStart) isStart = true;
                    imagesPre.add(image);
                } else if (isStart && app.getId() != image.getAppId()) break;
            }

            appMessage.setImages(imagesPre);
            appMessage.setCategories(categoriesPre);
            appMessages.add(appMessage);
        }

        apps.clear();
        categories.clear();
        images.clear();
    }

    public App getApp() {
        return app;
    }

    public void setApp(App app) {
        this.app = app;
    }

    public ArrayList<Image> getImages() {
        return images;
    }

    public void setImages(ArrayList<Image> images) {
        this.images = images;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }


    public MyException getException() {
        return exception;
    }

    public void setException(MyException exception) {
        this.exception = exception;
    }


}
