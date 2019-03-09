package com.dongkyoo.webe.controllers;

import com.dongkyoo.webe.services.UserService;
import com.dongkyoo.webe.vos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "users")
public class UserController {

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
}
