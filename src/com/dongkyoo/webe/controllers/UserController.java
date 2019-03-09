package com.dongkyoo.webe.controllers;

import com.dongkyoo.webe.services.UserService;
import com.dongkyoo.webe.datas.vos.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "users")
public class UserController {

    private Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("hi2")
    public String hi() {
        return "hi2";
    }

    @PostMapping("signup")
    public User signUp(@RequestBody User user) {
        return userService.insertUser(user);
    }

    @GetMapping("login")
    public User login(@RequestParam String id, @RequestParam String password) {
        User user = userService.login(id, password);
        if (user == null) {
            logger.info("id(" + id + ") 로그인 실패");
        } else {
            logger.info("id(" + id + ") 로그인 성공");
        }

        return user;
    }
}
