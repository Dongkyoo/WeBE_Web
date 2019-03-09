package com.dongkyoo.webe.services;

import com.dongkyoo.webe.mappers.UserMapper;
import com.dongkyoo.webe.vos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.token.Sha512DigestUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Base64Utils;

import java.util.Random;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User insertUser(User user) {
        byte[] salt = createRandomSalt();
        String saltBase64 = Base64Utils.encodeToString(salt);
        String encryptedPassword = Base64Utils.encodeToString(Sha512DigestUtils.sha(user.getPassword().getBytes() + saltBase64));
        user.setSalt(saltBase64);
        user.setPassword(encryptedPassword);

        userMapper.insertUser(user);
        return selectUser(user.getId());
    }

    public byte[] createRandomSalt() {
        byte[] bytes = new byte[32];
        Random random = new Random();
        random.nextBytes(bytes);
        return bytes;
    }

    public User selectUser(String id) {
        return userMapper.selectUser(id);
    }
}
