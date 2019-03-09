package com.dongkyoo.webe.services;

import com.dongkyoo.webe.mappers.UserMapper;
import com.dongkyoo.webe.vos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User insertUser(User user) {
        userMapper.insertUser(user);
        return selectUser(user.getId());
    }

    public User selectUser(String id) {
        return userMapper.selectUser(id);
    }
}
