package com.tao.night.blog.service;

import com.tao.night.blog.dao.UserDAO;
import com.tao.night.blog.dao.model.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/7/25.
 */
@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    public void insert(UserDO userDO) {
        userDAO.insert(userDO);
    }
}
