package com.tao.service;

import com.tao.mapper.UserMapper;
import com.tao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;

/**
 * Created by Administrator on 2017/7/25.
 */
@Service
public class UserService {
    @Autowired
    @Qualifier("userMapper")
    UserMapper userMapper;

    public void insert(User user) {
        userMapper.insertUser(user);
    }
}
