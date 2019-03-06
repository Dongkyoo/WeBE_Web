package com.dongkyoo.webe;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @ResponseBody
    @GetMapping("hi")
    public String hi() {
        return "hi";
    }
}
