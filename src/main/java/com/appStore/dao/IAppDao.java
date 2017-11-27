package com.appStore.dao;

import com.appStore.model.App;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface IAppDao {
    App getApp(int id);
    ArrayList<App> getAllApp(@Param("start") int start, @Param("offset") int offset);
}
