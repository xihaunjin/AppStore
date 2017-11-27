

package com.appStore.dao;

import com.appStore.model.User;

import java.util.ArrayList;

public interface IUserDao {

    User selectUser(long id);
    ArrayList<User> selectAllUser();

}