package com.tao.mapper;

import com.tao.model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/7/25.
 */
@Repository("userMapper")
public interface UserMapper {
    public void insertUser(User user);
}
