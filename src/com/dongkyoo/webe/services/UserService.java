package com.dongkyoo.webe.services;

import com.dongkyoo.webe.datas.dtos.PasswordSaltDto;
import com.dongkyoo.webe.mappers.UserMapper;
import com.dongkyoo.webe.datas.vos.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.token.Sha512DigestUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import java.util.Random;

@Service
public class UserService {

    private Logger logger = LogManager.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;

    public User insertUser(User user) {
        // 비밀번호 암호화
        byte[] salt = createRandomSalt();
        String saltBase64 = Base64Utils.encodeToString(salt);
        String encryptedPassword = Base64Utils.encodeToString(Sha512DigestUtils.sha(user.getPassword() + saltBase64));
        user.setSalt(saltBase64);
        user.setPassword(encryptedPassword);

        userMapper.insertUser(user);
        return userMapper.selectUser(user.getId());
    }

    public byte[] createRandomSalt() {
        byte[] bytes = new byte[32];
        Random random = new Random();
        random.nextBytes(bytes);
        return bytes;
    }

    public User login(String id, String password) {
        if (!userMapper.isExist(id))
            return null;

        // 비밀번호 인증
        PasswordSaltDto passwordSaltDto = userMapper.selectPasswordSalt(id);
        String encryptedPassword = Base64Utils.encodeToString(Sha512DigestUtils.sha(password + passwordSaltDto.getSalt()));
        if (encryptedPassword.equals(passwordSaltDto.getPassword())) {
            return userMapper.selectUser(id);
        }

        return null;
    }
}
