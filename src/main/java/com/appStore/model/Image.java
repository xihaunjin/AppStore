package com.appStore.model;

public class Image {
    private int id;
    private int appId;
    private String image;

    public void setId(int id) {
        this.id = id;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public int getAppId() {
        return appId;
    }

    public String getImage() {
        return image;
    }
}
