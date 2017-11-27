package com.appStore.service;

import com.appStore.model.User;

import java.util.ArrayList;

public interface IUserService {

     User selectUser(long userId);

     ArrayList<User> selectAllUser();

}