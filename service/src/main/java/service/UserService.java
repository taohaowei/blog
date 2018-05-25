package service;

import mapper.UserMapper;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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
