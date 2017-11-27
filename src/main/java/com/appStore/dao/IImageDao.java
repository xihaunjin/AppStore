package com.appStore.dao;

import com.appStore.model.Image;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface IImageDao {
    ArrayList<Image> getImage(int id);

    ArrayList<Image> getAllImage(@Param("start") int start, @Param("offset") int offset);

    ArrayList<Image> getAllImageByCId(@Param("start") int start, @Param("offset") int offset, @Param("id") int id);
}
