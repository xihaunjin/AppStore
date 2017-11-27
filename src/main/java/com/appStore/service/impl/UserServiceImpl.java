package com.appStore.service.impl;

import com.appStore.dao.IUserDao;
import com.appStore.model.User;
import com.appStore.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    public User selectUser(long userId) {
        return this.userDao.selectUser(userId);
    }

    public ArrayList<User> selectAllUser() {
        return this.userDao.selectAllUser();
    }


}
