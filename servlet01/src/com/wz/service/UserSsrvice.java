package com.wz.service;

import com.wz.dao.UserDao;
import com.wz.domain.User;

import java.sql.SQLException;

public class UserSsrvice {
    UserDao userDao = new UserDao();
    public int UserAdd(User user) throws SQLException {
        int i = userDao.UserAdd(user);
        return i;
    }
}
