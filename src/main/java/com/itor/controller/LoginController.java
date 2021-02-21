package com.itor.controller;

import com.itor.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "system/login_v2";
    }

    @PostMapping("/index")
    public String loginByUser(User user) {
        return "system/index";
    }

    @RequestMapping("/index_v148b2")
    public String index_v148b2() {
        return "system/index_v148b2";
    }
}
