package com.appStore.service;

import com.appStore.model.AppMessage;

import java.util.ArrayList;

public interface IAppService {
    AppMessage getAppMessage(int id);
    ArrayList<AppMessage> getAllAppMessage(int start,int offset);
}
